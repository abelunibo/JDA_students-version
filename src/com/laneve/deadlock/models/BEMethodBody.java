package com.laneve.deadlock.models;

import java.util.LinkedList;

import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.models.lam.LamSequence;
import com.laneve.deadlock.type.TypeObject;

public class BEMethodBody extends BEMethodDeclaration{
	LinkedList<BEInstructionLine> instructions;

	public BEMethodBody(LinkedList<BEInstructionLine> instructions) {
		this.instructions = instructions;
	}

	public LinkedList<BEInstructionLine> getInstructions() {
		return instructions;
	}
	
	@Override
	public LamBase generateLam(Environment environment) {
		LamSequence l = new LamSequence();
		environment.openScope();
		if(getModifier() != null && 
				getModifier().getModifier().contentEquals("synchronized"))
			environment.addLock(new TypeObject(getClassName()));
		
		for(BEInstructionLine i : instructions)
			l.createSequence(i.generateLam(environment)); 
		environment.closeScope();
		return l;
	}
}
