package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.exceptions.BEException;
import com.laneve.deadlock.models.BEConstantPool;
import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamAnd;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.type.TypeInt;
import com.laneve.deadlock.type.TypeObject;

public class BEGet extends BEInstructionLine implements BEInstruction{

	public BEGet(String text) {
		instructionName = text;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		LamAnd lamAnd =null;
		lamAnd =new LamAnd(LamBase.getZhatBar(environment.getLocks()), //zhhatbar
				LamBase.getThat(environment.getQueuethreads())); //tHat
		updateEnvironment(environment);
		return lamAnd;
	}

	@Override
	public void updateEnvironment(Environment environment){
		String getfieldRef = BEConstantPool.takeCpoolRef(environment.getConstantPool(),getRef());
		//String fieldType = getfieldRef.substring(0, getfieldRef.indexOf(" ")); //tipo del campo da modificare
		String fieldName = getfieldRef.substring(getfieldRef.indexOf(" ")+1, getfieldRef.lastIndexOf(" ")); //nome del campo da modificare
		String fieldObjectType = getfieldRef.substring(getfieldRef.lastIndexOf(" ")+1); //tipo dell'oggetto in cui e' contenuto il campo
		String firstLetter = getfieldRef.substring(0, 1);

		if(getName().equals("getfield")){
			
			if(firstLetter.contentEquals("L")){

				TypeObject o = null;
				try {
					o= (TypeObject) environment.popStack(); //tolgo dallo stack elemento da cui devo recuperare il campo
				} catch (BEException e) {
					e.printStackTrace();
					System.exit(1);
				}
				//fieldType = fieldType.substring(1); //rimuovi la L iniziale nella signature
				environment.pushStack(o.getFieldType(fieldName));
			}
			else{ //sto recuperando un tipo intero
				try {
					environment.popStack(); //tolgo l'elemento da cui devo recuperare l'intero
				} catch (BEException e) {
					e.printStackTrace();
				}
				environment.pushStack(new TypeInt());
			}
			
		}else if(getName().equals("getstatic")){ //devo mettere sullo stack un campo di una classe
			if(firstLetter.contentEquals("L")){
				environment.pushStack(environment.getClassObject(fieldObjectType).getFieldType(fieldName));
			}
			else environment.pushStack(new TypeInt());
		}

	}

}
