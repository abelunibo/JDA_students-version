package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.models.lam.LamZT;
import com.laneve.deadlock.type.TypeInt;

public class BEIinc extends BEInstructionLine implements BEInstruction{

	
	public BEIinc(String text) {
		instructionName = text;
	}

	@Override
	public LamBase generateLam(Environment environment) {	
		
		LamBase lzt = new LamZT();
		String lamZ = LamZT.getZhatBar(environment.getLocks());
		String lamT = LamZT.getThat(environment.getQueuethreads());
		lzt.setLam(lamZ+" & "+lamT);
//		Logger.logInfo(lzt.getLam());
		updateEnvironment(environment);
		return lzt;
	}
	
	
	@Override
	public void updateEnvironment(Environment environment) {
		
		String localVarIndex = getNat();
		
		/* e' inutile ottenere il valore da incrementare...tanto alla fine il
		 * il risultato sara' sempre un tipo INT
		 */
		//String inc = getNumber(); 
		
		environment.putLocalVar(localVarIndex, new TypeInt());
		
	}

}
