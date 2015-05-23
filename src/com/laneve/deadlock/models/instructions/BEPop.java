package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.exceptions.BEException;
import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;

public class BEPop extends BEInstructionLine implements BEInstruction{

	public BEPop(String text) {
		instructionName = text;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		handleEnvironment(environment);
		return super.generateLam(environment);
	}

	@Override
	public void handleEnvironment(Environment environment) {
		try {
			environment.popStack();
		} catch (BEException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}


}
