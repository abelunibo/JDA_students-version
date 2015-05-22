package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.models.BEInstruction;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;

public class BENotImplemented extends BEInstruction{

	public BENotImplemented(String text) {
		instructionName = text;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		return super.generateLam(environment);
	}

}
