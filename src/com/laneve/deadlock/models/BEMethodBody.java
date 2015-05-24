package com.laneve.deadlock.models;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Logger;

import com.laneve.deadlock.exceptions.BEException;
import com.laneve.deadlock.models.instructions.BEInvoke;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.models.lam.LamSequence;
import com.laneve.deadlock.type.Type; 

public class BEMethodBody extends BEBase{
	LinkedList<BEInstructionLine> instructions;
	BEMethodModifier methodModifier = null;
	BEMethodHeader methodHeader = null;
	HashMap<String, Integer> instructionMap;
	BEInstructionLine instructionTemp;
	Integer nextGoToInstruction = null;

	private static Logger LOGGER = Logger.getLogger("");


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
				
				LOGGER.info("----------------"+ instructions.get(i).getName() +"----------------\n");
				
				/* print Stack */
				String vars = "";
				for(Type obj : environment.getOperandStack()){
					vars = vars.concat(obj.getName() + ", ");
				}
				if(!vars.equals(""))
					vars = vars.substring(0, vars.length()-2);
				LOGGER.info("Stack:\t\t ["+vars+"]");
				  
				/* print LocalVar */
				Iterator it = environment.getLocalVar().keySet().iterator();
				vars = "";
				while (it.hasNext()) {
				   String key = it.next().toString();
				   String value = environment.getLocalVar().get(key).getName();
				   vars = vars.concat(key + " -> " + value.toString() +", ");
				}
				if(!vars.equals(""))
					vars = vars.substring(0, vars.length()-2);
				LOGGER.info("LocalVar:\t\t ["+ vars+"]");
				
				/* print Locks */
				vars = "";
				for(Type obj : environment.getLocks()){
					vars = vars.concat(obj.getName() + ", ");
				}
				if(!vars.equals(""))
					vars = vars.substring(0, vars.length()-2);
				LOGGER.info("Locks:\t\t ["+vars+"]");
				
				/* print  queueThreads*/
				vars = "";
				for(Type obj : environment.getQueuethreads()){
					vars = vars.concat(obj.getName() + ", ");
				}
				if(!vars.equals(""))
					vars = vars.substring(0, vars.length()-2);
				LOGGER.info("QueueThreads:\t ["+vars+"]\n");
		
			l.createSequence(instructions.get(i).generateLam(environment));
			instructionTemp = instructions.get(i);
		}
		environment.closeScope();
		return l;
	}
}
