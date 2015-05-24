package com.laneve.deadlock.models;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import com.laneve.deadlock.exceptions.BEException;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.models.lam.LamSequence;

public class BEMethodBody extends BEBase{
	LinkedList<BEInstructionLine> instructions;
	BEMethodModifier methodModifier = null;
	BEMethodHeader methodHeader = null;
	HashMap<String, Integer> instructionMap;
	BEInstructionLine instructionTemp;
	Integer nextGoToInstruction = null;


	public BEMethodBody(LinkedList<BEInstructionLine> instructions,
			HashMap<String, Integer> instructionMap) {
		this.instructions = instructions;
		this.instructionMap = instructionMap;
	}

	public HashMap<String, Integer> getInstructionMap() {
		return instructionMap;
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

	public BEInstructionLine getInstructionTemp() {
		return instructionTemp;
	}
	
	public void setNextGotoInstruction(Integer indexListTojump){
			nextGoToInstruction = indexListTojump;
	}
	
	public Integer getNextGotoInstruction(){
		return nextGoToInstruction;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		LamSequence l = new LamSequence();
		environment.openScope(this);
		for(int i = 0 ; i < instructions.size() ;i++){
			if(!(nextGoToInstruction == null)){
				i = nextGoToInstruction;
				nextGoToInstruction = null;
			}
//			System.out.println(instructions.get(i).getName()+"--");
//			System.out.print("Stack--> "+ environment.getOperandStack().toString());
//			  
//			Iterator it = environment.getLocalVar().keySet().iterator();
//			  
//			System.out.print("\nLocalVar-> ");
//
//			while (it.hasNext()) {
//			   String key = it.next().toString();
//			   String value = environment.getLocalVar().get(key).getName();
//			   System.out.print(key + " " + value);
//			   System.out.print(" , ");
//			}
//			System.out.println();
			l.createSequence(instructions.get(i).generateLam(environment));
			instructionTemp = instructions.get(i);
		}
		environment.closeScope();
		return l;
	}
}
