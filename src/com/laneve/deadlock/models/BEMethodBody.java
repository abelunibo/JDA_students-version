package com.laneve.deadlock.models;

import java.util.LinkedList;

import com.laneve.deadlock.exceptions.BEException;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.models.lam.LamSequence;

public class BEMethodBody extends BEBase{
	LinkedList<BEInstructionLine> instructions;
	BEMethodModifier methodModifier=null;
	BEMethodHeader methodHeader=null;

	//TODO istruzioneTemp = vecchia istruzione

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

	//TODO getIstruzionePrecedente 
	//TODO setIstruzioneSuccessivaGoto


	@Override
	public LamBase generateLam(Environment environment) {
		LamSequence l = new LamSequence();
		environment.openScope(this);
		//TODO for(int i = 0 ; i < instructions.size ;i++)
		//TODO i = istruzionesuccessiva;
		for(BEInstructionLine i : instructions){
			 /*System.out.println(i.getName()+"--");
			System.out.print("Stack--> "+ environment.getOperandStack().toString());
			  
			Iterator it = environment.getLocalVar().keySet().iterator();
			  
			System.out.print("\nLocalVar-> ");

			while (it.hasNext()) {
			   String key = it.next().toString();
			   String value = environment.getLocalVar().get(key).getName();
			   System.out.print(key + " " + value);
			   System.out.print(" , ");
			}
			
			System.out.println();*/
			//TODO if setIstruzioneSuccessiva == null{
			l.createSequence(i.generateLam(environment)); 
			//TODO istruzioneTemp = i;
		}
		
		environment.closeScope();
		return l;
	}
}
