package com.laneve.deadlock.models;

import java.util.LinkedList;

import com.laneve.deadlock.exceptions.BEException;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.models.lam.LamSequence;

public class BEMethodBody extends BEBase{
	LinkedList<BEInstructionLine> instructions;
	BEMethodModifier methodModifier=null;
	BEMethodHeader methodHeader=null;

	public BEMethodBody(LinkedList<BEInstructionLine> instructions) {
		this.instructions = instructions;
	}

	public LinkedList<BEInstructionLine> getInstructions() {
		return instructions;
	}
	
	public void setMethodSignature(BEMethodModifier methodModifier,
			BEMethodHeader methodHeader) throws BEException{
		
		if(this.methodHeader!=null){
			throw new BEException("La signature di un methodBody non puo' essere modificata");
		}
		
		if(methodHeader==null){
			throw new BEException("La signature di un methodBody deve avere methodHeader");
		}
		
		this.methodModifier=methodModifier;
		this.methodHeader=methodHeader;
	}
	
	public BEMethodHeader getMethodHeader() throws BEException{
		return methodHeader;
	}

	public BEMethodModifier getMethodModifier() {
		return methodModifier;
	}
	
	@Override
	public LamBase generateLam(Environment environment) {
		LamSequence l = new LamSequence();
		environment.openScope(this);
		for(BEInstructionLine i : instructions)
			l.createSequence(i.generateLam(environment)); 
		environment.closeScope();
		return l;
	}
}
