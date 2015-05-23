package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;

public class BEMonitorEnter extends BEInstructionLine implements BEInstruction{

	
	public BEMonitorEnter(String text) {
		instructionName = text;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		//TODO calcola lam pima di aggioornare l'ambiente
		handleEnvironment(environment);
		return super.generateLam(environment);
	}

	@Override
	public void handleEnvironment(Environment environment) {
		String topStack = environment.popStack();
		environment.addLock(topStack);
	}

}
