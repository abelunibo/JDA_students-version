package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;

public class BEDup extends BEInstructionLine implements BEInstruction{

	public BEDup(String text) {
		instructionName = text;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		handleEnvironment(environment);
		return super.generateLam(environment);

	}

	@Override
	public void handleEnvironment(Environment environment) {
	// da scommentare quando saranno implementate tutte le regole
	//	environment.pushStack(environment.getOperandStack().getFirst());
	}


}
