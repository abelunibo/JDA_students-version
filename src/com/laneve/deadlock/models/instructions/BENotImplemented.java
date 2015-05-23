package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;

public class BENotImplemented extends BEInstructionLine implements BEInstruction{

	public BENotImplemented(String text) {
		instructionName = text;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		
		//TODO tutti i not implemented devono calcolare le LAM come "T & Z"
		
		return super.generateLam(environment);
	}

	@Override
	public void handleEnvironment(Environment environment) {		
	}



}
