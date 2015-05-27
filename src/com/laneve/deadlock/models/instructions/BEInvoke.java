package com.laneve.deadlock.models.instructions;



import com.laneve.deadlock.exceptions.BEException;
import com.laneve.deadlock.models.BEConstantPool;
import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.models.lam.LamZT;
import com.laneve.deadlock.type.Type;
import com.laneve.deadlock.type.TypeInt;
import com.laneve.deadlock.type.TypeObject;

public class BEInvoke extends BEInstructionLine implements BEInstruction{
	private String lamEnd="";

	public BEInvoke(String text) {
		instructionName = text;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		LamBase lzt = new LamZT();		
		String lamZ = LamZT.getZhatBar(environment.getLocks());
		String lamT = LamZT.getThat(environment.getQueuethreads());
		updateEnvironment(environment);
		if(!lamEnd.isEmpty())
			lamEnd= " & "+lamEnd;
		lzt.setLam(lamZ+" & "+lamT+ lamEnd);
		return lzt;
	}

	@Override
	public void updateEnvironment(Environment environment) {
		String parameters = "";
		int numParameters=0;
		StringBuffer a = new StringBuffer();
		String obThis= "";

		if(getName().contentEquals("invokespecial")){
			String signature = BEConstantPool.takeCpoolRef(environment.getConstantPool(),getRef());
			String superClass = signature.substring(signature.lastIndexOf(" ")+1);
			TypeObject ob=null;
			int openP = signature.indexOf("(");
			int closedP = signature.indexOf(")");
			parameters =  signature.substring(openP+1, closedP);
			numParameters=0;
			if(parameters.contains(";")){
				for (int i = 0; i < parameters.length(); i++) {
					if (parameters.charAt(i) == ';') {
						numParameters++;
					}
				}
			}
			try{

				for(int i = 0; i<numParameters; i++){
					Type type = environment.popStack();

					a.insert(0,type.getName()+","); //rimuovere questa riga se si scommenta parte sotto
					/*String fieldParam = "";
					if(!type.isInt()){

						//System.out.println(((TypeObject)type).getRawName());
						LinkedHashMap<String, LinkedHashMap<String, String>> field = environment.getFields();
					//	System.out.println(field);

						String name = ((TypeObject)type).getRawName();
						LinkedHashMap<String, String> fieldNameAndTypes = field.get(((TypeObject)type).getRawName());
						//TODO da cambiare in funzione ricorsiva che prende la profondita come parametro
						if(fieldNameAndTypes != null){
							for (Map.Entry<String, String> f : fieldNameAndTypes.entrySet()){
								String fieldType = f.getValue().substring(1);
								fieldParam += fieldType+"£"+f.getKey()+"£"+type.getName()+",";
								if(!type.isInt()){
									LinkedHashMap<String, String> fieldNameAndTypes2 = field.get(fieldType);
									if(fieldNameAndTypes2 != null){
										for (Map.Entry<String, String> f2 : fieldNameAndTypes2.entrySet()){
											String fieldType2 = f2.getValue();
											fieldParam += fieldType2+"£"+f2.getKey()+"£"+fieldType;
											//System.out.println(fieldParam);
										}
									}
								}
							}
						}
					}
					a.insert(0,type.getName()+","+fieldParam);*/
				}

				a.insert(0,"(");
				ob= (TypeObject) environment.popStack();
				obThis = ob.getName();
				if(!ob.getRawName().equals(superClass)) // siamo nell'init della superclasse
					a.insert(1,superClass +",");
				else //chiama init della mia classe
					a.insert(1,obThis +",");
				a.deleteCharAt(a.length()-1);
				a.insert(a.length(),")");
				a.insert(0," "+environment.getClassName().toUpperCase());
			} catch (BEException e) {
				e.printStackTrace();
				System.exit(1);
			}


			if(ob.getRawName().equals(superClass)){ //è il nostro init
				obThis = "(v " + obThis + ")";
				this.lamEnd= obThis + a.toString();
			} else { //è l'init della superclasse
				this.lamEnd= a.toString();
			}


		}
		else if(getName().contentEquals("invokevirtual")){


			String signature = BEConstantPool.takeCpoolRef(environment.getConstantPool(),getRef());


			if(signature.equals("() start java/lang/Thread")){ //invokevirtual start

				try {
					environment.addThread(environment.popStack());
				} catch (BEException e) {
					e.printStackTrace();
					System.exit(1);
				}
			} //fine start

			else if(signature.equals("() join java/lang/Thread")){ //invokevirtual join
				TypeObject tName=null;
				try {
					tName=(TypeObject) environment.popStack();
					environment.removeThread(tName);
				} catch (BEException e) {
					e.printStackTrace();
					System.exit(1);
				}

				String topZ = LamZT.getTopZbar(environment.getQueuethreads());
				if(topZ!=null)
					this.lamEnd= "("+ topZ + "," + tName.getName() +")";
			} //fine join

			else{ //invokevirtual standard

				int openP = signature.indexOf("(");
				int closedP = signature.indexOf(")");
				String mName = signature.substring(signature.indexOf(" ")+1,signature.lastIndexOf(" "));
				parameters =  signature.substring(openP+1, closedP);
				numParameters=0;
				if(parameters.contains(";")){
					//Logger.logInfo(parameters);
					for (int i = 0; i < parameters.length(); i++) {
						if (parameters.charAt(i) == ';') {
							numParameters++;
						}
					}
				}

				try{
					for(int i = 0; i<numParameters; i++){
						a.insert(0,environment.popStack().getName()+",");
					}
					a.insert(0,"(");
					obThis = environment.popStack().getName();
					a.insert(1,obThis+",");
					a.deleteCharAt(a.length()-1);
					a.insert(a.length(),")");
					mName.replaceAll(".", "/");
					if(!mName.contains("/")){
						mName= environment.getClassName() + "/" +mName;
					}
					a.insert(0, mName.toUpperCase());
				} catch (BEException e) {
					e.printStackTrace();
					System.exit(1);
				}


				this.lamEnd= a.toString();

				String topZ = LamZT.getTopZbar(environment.getQueuethreads());
				if(topZ!=null)
					this.lamEnd= lamEnd +" & " + "("+ topZ + "," + obThis +")";
			}

			int index = signature.indexOf(")");
			String resultType= signature.substring(index,index+1);

			if(resultType.equals("L")){

				String resultTypeClass = signature.substring(index+1,signature.indexOf(" "));

				environment.pushStack(new TypeObject(resultTypeClass,environment.getFields(),false));

			}
			else if(resultType.equals("I")){

				environment.pushStack(new TypeInt());
			}

		}
		else if(getName().contentEquals("invokestatic")){

			String signature = BEConstantPool.takeCpoolRef(environment.getConstantPool(),getRef());

			int openP = signature.indexOf("(");
			int closedP = signature.indexOf(")");
			parameters =  signature.substring(openP+1, closedP);
			String mName = signature.substring(signature.indexOf(" ")+1,signature.lastIndexOf(" "));
			String className = signature.substring(signature.lastIndexOf(" ")+1);
			numParameters=0;
			if(parameters.contains(";")){
				//Logger.logInfo(parameters);
				for (int i = 0; i < parameters.length(); i++) {
					if (parameters.charAt(i) == ';') {
						numParameters++;
					}
				}

			}

			try{
				for(int i = 0; i<numParameters; i++){
					a.insert(0,environment.popStack().getName()+",");
				}
				a.insert(0,"(");
				a.insert(a.length(),")");
				mName.replaceAll(".", "/");
				if(!mName.contains("/")){
					mName= environment.getClassName() + "/" +mName;
				}
				a.insert(0,mName.toUpperCase());
			} catch (BEException e) {
				e.printStackTrace();
				System.exit(1);
			}


			// non devo recuperare alcun oggetto this su cui viene invocato il metodo perchè è static

			this.lamEnd = obThis + a.toString();

			String topZ = LamZT.getTopZbar(environment.getQueuethreads());

			if(topZ!=null)
				this.lamEnd= lamEnd +" & " + "("+ topZ + "," + className +")";

			int index = signature.indexOf(")");
			String resultType= signature.substring(index,index+1);

			if(resultType.equals("L")){

				String resultTypeClass = signature.substring(index+1,signature.indexOf(" "));

				environment.pushStack(new TypeObject(resultTypeClass,environment.getFields(),false));

			}
			else if(resultType.equals("I")){

				environment.pushStack(new TypeInt());
			}

		}


	}
}
