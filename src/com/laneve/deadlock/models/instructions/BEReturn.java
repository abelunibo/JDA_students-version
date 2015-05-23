package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.exceptions.BEException;
import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;

public class BEReturn extends BEInstructionLine implements BEInstruction{

	public BEReturn(String text) {
		instructionName = text;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		//TODO generare lam
		handleEnvironment(environment);
		return super.generateLam(environment);
	}

	@Override
	public void handleEnvironment(Environment environment) {
		
		if(getName().contentEquals("ireturn") || getName().contentEquals("areturn")){
			
			try {
				environment.popStack();
			} catch (BEException e) {
				e.printStackTrace();
				System.exit(1);
			}
			
		}else if(getName().contentEquals("return")){
			
			//ritorna semplicemente
			
		}
		
	}

}
