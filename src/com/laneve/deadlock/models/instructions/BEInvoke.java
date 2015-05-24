package com.laneve.deadlock.models.instructions;

import java.util.logging.Logger;

import com.laneve.deadlock.exceptions.BEException;
import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.models.lam.LamZT;
import com.laneve.deadlock.type.Type;
import com.laneve.deadlock.type.TypeObject;

public class BEInvoke extends BEInstructionLine implements BEInstruction{
	private String signature="";
	private static Logger LOGGER = Logger.getLogger(BEInvoke.class.getSimpleName());
	
	public BEInvoke(String text) {
		instructionName = text;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		LamBase lzt = new LamZT();		
		LamZT.addDebugZT(environment);
		String lamZ = LamZT.getZhatBar(environment.getLocks());
		String lamT = LamZT.getThat(environment.getQueuethreads());
		changeEnvironment(environment);
		lzt.setLam(lamZ+" & "+lamT+" & "+signature);
		return lzt;
	}

	@Override
	public void changeEnvironment(Environment environment) {
		String parameters = "";
		int numParameters=0;
		
		if(getName().contentEquals("invokespecial")){
			//Logger.logInfo(environment.takeCpoolRef(getRef()));			
			String signature = environment.takeCpoolRef(getRef());
			int openP = signature.indexOf("(");
			int closedP = signature.indexOf(")");
			parameters =  signature.substring(openP+1, closedP);
			numParameters=0;
			if(parameters.contains(";")){
				//Logger.logInfo(parameters);
				for (int i = 0; i < parameters.length(); i++) {
					if (parameters.charAt(i) == ';') {
						numParameters++;
					}
				}
				//Logger.logInfo(String.valueOf(numParameters));
			}
			
			
			
			/*TypeObject obThis=null;
			//rimuovi l'oggetto (this) su cui e' stato chiamato il metodo
			try {
				obThis = (TypeObject) environment.popStack();
			} catch (BEException e) {
				e.printStackTrace();
			}
			signature+="(v "+ obThis.getName() +") <init>";
			signature+= "(" + pars + ")";*/
		}
		else if(getName().contentEquals("invokevirtual")){

			

		}
		else if(getName().contentEquals("invokestatic")){

		}
	    
		//System.out.println(signature);

		//TODO solo per debug
		/*Type uno = new TypeObject("P2");
		Type due = new TypeObject("P1");
		Type tre = new TypeObject("java/lang/Object");
		environment.pushStack(tre);
		environment.pushStack(due);
		environment.pushStack(uno);*/

		/*try {
		    StringBuffer a = new StringBuffer(signature);
		    //TODO solo per debug numParameters  
		    // viene preso prima 
		    numParameters = 2;//P1 //P2 
			for(int i = 0; i<numParameters; i++){
				a.insert(0,environment.popStack().getName()+",");
			}
		    a.insert(0,"(");
		    a.insert(1,environment.popStack().getName()+",");
		    a.deleteCharAt(a.length()-1);
		    a.insert(a.length(),")");
			a.insert(0,"<init> ");
			signature = a.toString();

			//System.out.println(a);
		} catch (BEException e) {
			e.printStackTrace();
			System.exit(1);
		}*/
	}
}
