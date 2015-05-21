package com.laneve.deadlock.models;

import java.util.LinkedList;

public class BEMethodBody extends BEBase{
	LinkedList<BEInstruction> instructions; 
	
	public BEMethodBody(LinkedList<BEInstruction> instructions) {
		this.instructions = instructions;
	}
	public LinkedList<BEInstruction> getInstructions() {
		return instructions;
	}
	
}
