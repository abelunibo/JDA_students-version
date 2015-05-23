package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;

public class BEConst extends BEInstructionLine implements BEInstruction{
	
	public BEConst(String text) {
		instructionName = text;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		//TODO generare lam qui
		handleEnvironment(environment);
		return super.generateLam(environment);

	}

	@Override
	public void handleEnvironment(Environment environment) {
		
		
		
	}

}
