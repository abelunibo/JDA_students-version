package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;

public class BEAthrow extends BEInstructionLine implements BEInstruction{
	
	public BEAthrow(String text) {
		instructionName = text;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		return super.generateLam(environment);
	}

	@Override
	public void handleEnvironment(Environment environment) {
		// TODO Auto-generated method stub
		
	}


}
