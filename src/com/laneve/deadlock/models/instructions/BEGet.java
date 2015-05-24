package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.exceptions.BEException;
import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.models.lam.LamZT;
import com.laneve.deadlock.type.TypeInt;
import com.laneve.deadlock.type.TypeObject;

public class BEGet extends BEInstructionLine implements BEInstruction{

	public BEGet(String text) {
		instructionName = text;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		LamBase lzt = new LamZT();		
		LamZT.addDebugZT(environment);
		String lamZ = LamZT.getZhatBar(environment.getLocks());
		String lamT = LamZT.getThat(environment.getQueuethreads());	
		lzt.setLam(lamZ+" & "+lamT);
		changeEnvironment(environment);		
		return lzt;
	}

	@Override
	public void changeEnvironment(Environment environment){
		String getfieldRef = environment.takeCpoolRef(getRef());
		String fieldType = getfieldRef.substring(0, getfieldRef.indexOf(" "));
		String fieldName = getfieldRef.substring(getfieldRef.indexOf(" ")+1, getfieldRef.lastIndexOf(" "));
		String fieldObjectType = getfieldRef.substring(getfieldRef.lastIndexOf(" ")+1);
		String firstLetter = getfieldRef.substring(0, 1);
		System.out.println(fieldType +"  "+fieldName+" "+fieldObjectType);
		System.out.println(getfieldRef);

		if(getName().equals("getfield")){
			if(firstLetter.contentEquals("L")){

				TypeObject o = null;
				try {
					o= (TypeObject) environment.popStack(); //tolgo dallo stack elemento da cui devo recuperare il campo
				} catch (BEException e) {
					e.printStackTrace();
					System.exit(1);
				}

				environment.pushStack(new TypeObject(new TypeObject(fieldType), fieldName, o));
			}
			else environment.pushStack(new TypeInt());
		}else if(getName().equals("getstatic")){
			if(firstLetter.contentEquals("L")){
				environment.pushStack(new TypeObject(new TypeObject(fieldType), fieldName, new TypeObject(fieldObjectType)));
			}
			else environment.pushStack(new TypeInt());
		}

	}

}
