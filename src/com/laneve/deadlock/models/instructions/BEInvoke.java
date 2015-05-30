package com.laneve.deadlock.models.instructions;



import java.util.ArrayList;
import java.util.LinkedList;

import com.laneve.deadlock.exceptions.BEException;
import com.laneve.deadlock.models.BEConstantPool;
import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamAnd;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.models.lam.LamCouple;
import com.laneve.deadlock.models.lam.LamInvoke;
import com.laneve.deadlock.type.Type;
import com.laneve.deadlock.type.TypeInt;
import com.laneve.deadlock.type.TypeObject;

public class BEInvoke extends BEInstructionLine implements BEInstruction{
	
	private LamInvoke lamInv = null; //non e' presente per invocazione di metodi della standard library (tipo start e join)
	private LamCouple lamC=null; // la coppia di dipendenza tra chiamante e chiamato non e' sempre presente

	public BEInvoke(String text) {
		instructionName = text;
	}

	@Override
	public LamBase generateLam(Environment environment) {
				
		/* la coda dei thread puo' essere aggiornata in una start o una join quindi primo mi salvo la coda attuale
		 * per poi usarla nelle lam
		 */
		LinkedList<TypeObject> threads = new LinkedList<TypeObject>(environment.getQueuethreads());
				
		/* devo aggiornare prima l'environment così mentre faccio la pop dei parametri dallo stack 
		 * li aggiungo alla signature della mia LAM */
		updateEnvironment(environment); 
		
		LamAnd lamAnd =null;
			lamAnd =new LamAnd(LamBase.getZhatBar(environment.getLocks()), //zhhatbar
			LamBase.getThat(threads), //that
			lamInv, //invocazione di metodo
			lamC); //dipendenza chiamante e chiamato
		
		return lamAnd;
	}

	@Override
	public void updateEnvironment(Environment environment) {
		String parameters="";
		int numParameters=0;
		ArrayList<Type> pars = new ArrayList<Type>();
		
		if(getName().contentEquals("invokespecial")){ //init
			
			//genera LAM
			String signature = BEConstantPool.takeCpoolRef(environment.getConstantPool(),getRef());
			//String methodName = signature.substring(signature.indexOf(" ")+1,signature.lastIndexOf(" "));
	
			String methodClass = signature.substring(signature.lastIndexOf(" ")+1);
			TypeObject ob=null;
			int openP = signature.indexOf("(");
			int closedP = signature.indexOf(")");
			parameters =  signature.substring(openP+1, closedP);
			numParameters=0;		
			for (int i = 0; i < parameters.length(); i++) {
				if (parameters.charAt(i) == 'L') { //e' tipo classe
					int index= parameters.indexOf(';',i);
					if(index!=-1){
						numParameters++;
						i=index;
						continue;
					}
				}
				if(parameters.charAt(i) == 'I'){
					numParameters++;
				}
			
			}
			try{
				for(int i = 0; i<numParameters; i++){
					Type type = environment.popStack(); 
					pars.add(0,type); // l'ultimo parametro va in cima perchè i parametri nello stack sono in ordine inverso
				}
	
				ob= (TypeObject) environment.popStack(); //il tipo dell'oggetto da inizializzare
				pars.add(0,ob);
			}
			catch(BEException e){
				e.printStackTrace();
				System.exit(1);
			}
			if(environment.getFields().containsKey(methodClass)) //sto invocando un costruttore di una delle classi user-defined
				try {
					lamInv = new LamInvoke(methodClass,ob.getClassName(), pars);
				} catch (BEException e) {
					e.printStackTrace();
					System.exit(1);
				} 				
	
		}else if(getName().contentEquals("invokevirtual")){


			String signature = BEConstantPool.takeCpoolRef(environment.getConstantPool(),getRef());


			if(signature.equals("()V start java/lang/Thread")){ //invokevirtual start

				try {
					environment.addThread((TypeObject)environment.popStack());
				} catch (BEException e) {
					e.printStackTrace();
					System.exit(1);
				}
			} //fine start

			else if(signature.equals("()V join java/lang/Thread")){ //invokevirtual join
				TypeObject tName=null;
				try {
					tName=(TypeObject) environment.popStack();
					environment.removeThread(tName);
				} catch (BEException e) {
					e.printStackTrace();
					System.exit(1);
				}

				lamC= new LamCouple(LamBase.getTopZbar(environment.getLocks()),tName.getName());

			} //fine join

			else{ //invokevirtual standard

				//genera LAM
				String methodClass = signature.substring(signature.lastIndexOf(" ")+1);
				String methodName = signature.substring(signature.indexOf(" ")+1,signature.lastIndexOf(" "));
								
				TypeObject ob=null;
				int openP = signature.indexOf("(");
				int closedP = signature.indexOf(")");
				parameters =  signature.substring(openP+1, closedP);
				numParameters=0;
				for (int i = 0; i < parameters.length(); i++) {
					if (parameters.charAt(i) == 'L') { //e' tipo classe
						int index= parameters.indexOf(';',i);
						if(index!=-1){
							numParameters++;
							i=index;
							continue;
						}
					}
					if(parameters.charAt(i) == 'I'){
						numParameters++;
					}
				
				}
				try{
					for(int i = 0; i<numParameters; i++){
						Type type = environment.popStack();
						pars.add(0,type);
					}
	
					ob= (TypeObject) environment.popStack(); // il tipo dell'oggetto su cui ho invocato il metodo
					pars.add(0,ob);
					if(environment.getFields().containsKey(methodClass)){ //non considero chiamate a metodi su classi non conosciute
						lamInv = new LamInvoke(ob.getClassName(), methodName, pars); 
						lamC= new LamCouple(LamBase.getTopZbar(environment.getLocks()),ob.getName());
					}
				}catch(BEException e){
					e.printStackTrace();
					System.exit(1);
				}

			}
			
			//devo aggiungere allo stack il tipo di ritorno (se c'e')
			int index = signature.indexOf(")");
			String resultType= signature.substring(index,index+1);
			
			if(resultType.equals("V") || resultType.equals("")){

				return; //tipo di ritorno void niente da aggiungere sullo stack
				
			}else if(resultType.equals("L")){

				String resultTypeClass = signature.substring(index+1,signature.indexOf(" "));

				environment.pushStack(new TypeObject(resultTypeClass,environment.getFields(),false));

			}
			else if(resultType.equals("I")){

				environment.pushStack(new TypeInt());
			}

		}
		else if(getName().contentEquals("invokestatic")){

			//genera LAM
			String signature = BEConstantPool.takeCpoolRef(environment.getConstantPool(),getRef());
			String methodClass = signature.substring(signature.lastIndexOf(" ")+1);
			String methodName = signature.substring(signature.indexOf(" ")+1,signature.lastIndexOf(" "));
			int openP = signature.indexOf("(");
			int closedP = signature.indexOf(")");
			parameters =  signature.substring(openP+1, closedP);
			numParameters=0;
			for (int i = 0; i < parameters.length(); i++) {
				if (parameters.charAt(i) == 'L') { //e' tipo classe
					int index= parameters.indexOf(';',i);
					if(index!=-1){
						numParameters++;
						i=index;
						continue;
					}
				}
				if(parameters.charAt(i) == 'I'){
					numParameters++;
				}
			
			}
			try{
				for(int i = 0; i<numParameters; i++){
					Type type = environment.popStack();
					pars.add(type);
				}
	
				// il tipo dell'oggetto su cui ho invocato il metodo e' la classe quindi non devo recuperare
				// alcun oggetto dallo stack
				
				if(environment.getFields().containsKey(methodClass)){ //non considero chiamate a metodi su classi non conosciute
					lamInv = new LamInvoke(methodClass,methodName, pars);
					lamC= new LamCouple(LamBase.getTopZbar(environment.getLocks()),environment.getClassObject(methodClass).getName());
				}
			}catch(BEException e){
				e.printStackTrace();
				System.exit(1);
			}
			//devo aggiungere allo stack il tipo di ritorno (se c'e')
			int index = signature.indexOf(")");
			String resultType= signature.substring(index,index+1);
			
			if(resultType.equals("V")){
	
				return; //tipo di ritorno void niente da aggiungere sullo stack
				
			}else if(resultType.equals("L")){
	
				String resultTypeClass = signature.substring(index+1,signature.indexOf(" "));
	
				environment.pushStack(new TypeObject(resultTypeClass,environment.getFields(),false));
	
			}
			else if(resultType.equals("I")){
	
				environment.pushStack(new TypeInt());
			}

		}

	}
}
