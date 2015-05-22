package com.laneve.deadlock.models;

import java.util.LinkedList;

import com.laneve.deadlock.models.lam.LamBase;

public class BEMethodBody extends BEBase{
	LinkedList<BEInstruction> instructions;
	//LinkedList<LamBase> lamebase;


	public BEMethodBody(LinkedList<BEInstruction> instructions) {
		this.instructions = instructions;
	}

	public LinkedList<BEInstruction> getInstructions() {
		return instructions;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		LamBase l = null;
		environment.openScope();
		for(BEInstruction i : instructions)
			l = i.generateLam(environment); 
		environment.closeScope();

		return l;
	}
}
