package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;

public class BEMonitorExit extends BEInstructionLine implements BEInstruction{

	public BEMonitorExit(String text) {
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
