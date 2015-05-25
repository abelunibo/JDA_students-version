package com.laneve.deadlock.models.instructions;


import com.laneve.deadlock.exceptions.BEException;
import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.models.lam.LamZT;
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
			String signature = environment.takeCpoolRef(getRef());
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
			else{
				try{
					for(int i = 0; i<numParameters; i++){
						a.insert(0,environment.popStack().getName()+",");
					}
					a.insert(0,"(");
					obThis = environment.popStack().getName();
					a.insert(1,obThis +",");
					a.deleteCharAt(a.length()-1);
					a.insert(a.length(),")");
					a.insert(0," <init> ");
				} catch (BEException e) {
					e.printStackTrace();
					System.exit(1);
				}
			}

			obThis = "(v " + obThis + ")";

			this.lamEnd= obThis + a.toString();

		}
		else if(getName().contentEquals("invokevirtual")){


			String signature = environment.takeCpoolRef(getRef());


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
				}else{

					try{
						for(int i = 0; i<numParameters; i++){
							a.insert(0,environment.popStack().getName()+",");
						}
						a.insert(0,"(");
						obThis = environment.popStack().getName();
						a.insert(1,obThis+",");
						a.deleteCharAt(a.length()-1);
						a.insert(a.length(),")");
						a.insert(0, mName);
					} catch (BEException e) {
						e.printStackTrace();
						System.exit(1);
					}

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

				environment.pushStack(new TypeObject(resultTypeClass,
						Integer.valueOf(getIndex().substring(0,resultTypeClass.length()-1))));

			}
			else if(resultType.equals("I")){

				environment.pushStack(new TypeInt());
			}

		}
		else if(getName().contentEquals("invokestatic")){

			String signature = environment.takeCpoolRef(getRef());

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
				
			}else{

				try{
					for(int i = 0; i<numParameters; i++){
						a.insert(0,environment.popStack().getName()+",");
					}
					a.insert(0,"(");
					a.insert(a.length(),")");
					a.insert(0,className+"."+mName);
				} catch (BEException e) {
					e.printStackTrace();
					System.exit(1);
				}

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

				environment.pushStack(new TypeObject(resultTypeClass,
						Integer.valueOf(getIndex().substring(0,resultTypeClass.length()-1))));

			}
			else if(resultType.equals("I")){

				environment.pushStack(new TypeInt());
			}

		}


	}
}
