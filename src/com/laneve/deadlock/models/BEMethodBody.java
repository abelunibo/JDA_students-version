package com.laneve.deadlock.models;

import java.util.LinkedList;

import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.models.lam.LamSequence;

public class BEMethodBody extends BEBase{
	LinkedList<BEInstruction> instructions;

	public BEMethodBody(LinkedList<BEInstruction> instructions) {
		this.instructions = instructions;
	}

	public LinkedList<BEInstruction> getInstructions() {
		return instructions;
	}
	
	@Override
	public LamBase generateLam(Environment environment) {
		LamSequence l = new LamSequence();
		environment.openScope();
		for(BEInstruction i : instructions)
			l.createSequence(i.generateLam(environment)); 
		environment.closeScope();
		return l;
	}
}
