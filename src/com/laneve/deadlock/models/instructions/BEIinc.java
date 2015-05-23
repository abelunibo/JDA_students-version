package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;

public class BEIinc extends BEInstructionLine implements BEInstruction{

	
	public BEIinc(String text) {
		instructionName = text;
	}

	@Override
	public LamBase generateLam(Environment environment) {	
		
		String lamZ = LamZT.getZhatBar(environment.getLocks());
		String lamT = LamZT.getThat(environment.getQueuethreads());	
		
		lzt.setLam(lamZ+" & "+lamT);
		handleEnvironment(environment);
		return super.generateLam(environment);
	}
	
	
	@Override
	public void handleEnvironment(Environment environment) {
		
		String localVarIndex = getNat();
		
		/* e' inutile ottenere il valore da incrementare...tanto alla fine il
		 * il risultato sara' sempre un tipo INT
		 */
		//String inc = getNumber(); 
		
		environment.putLocalVar(localVarIndex, "INT");
		
	}

}
