package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;

public class BEIinc extends BEInstructionLine implements BEInstruction{

	
	public BEIinc(String text) {
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
		// TODO Auto-generated method stub
		
	}

}
