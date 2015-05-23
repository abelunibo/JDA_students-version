package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.exceptions.BEException;
import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;

public class BEOperation extends BEInstructionLine implements BEInstruction{

	public BEOperation(String text) {
		instructionName = text;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		//TODO generare LAM qui con T & Z
		handleEnvironment(environment);
		return super.generateLam(environment);
	}

	@Override
	public void handleEnvironment(Environment environment) {

		try {
			environment.popStack(2);
		} catch (BEException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		environment.pushStack("INT");
		
	}


}
