package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.exceptions.BEException;
import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;

public class BEInvoke extends BEInstructionLine implements BEInstruction{
	private String signature;
	
	public BEInvoke(String text) {
		instructionName = text;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		return super.generateLam(environment);
	}

	@Override
	public void handleEnvironment(Environment environment) {
		// TODO Auto-generated method stub
		if(getName().contentEquals("invokespecial")){
			//((v di new) parametri) <init>
		}
		try {
			signature = environment.popStack();
		} catch (BEException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

}
