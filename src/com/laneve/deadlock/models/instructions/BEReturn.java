package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.exceptions.BEException;
import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.models.lam.LamZT;

public class BEReturn extends BEInstructionLine implements BEInstruction{

	public BEReturn(String text) {
		instructionName = text;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		LamBase lzt = new LamZT();		
		LamZT.addDebugZT(environment);
		String lamZ = LamZT.getZhatBar(environment.getLocks());
		String lamT = LamZT.getThat(environment.getQueuethreads());	
		lzt.setLam(lamZ+" & "+lamT);
//		Logger.logInfo(lzt.getLam());
		changeEnvironment(environment);		
		return lzt;
	}

	@Override
	public void changeEnvironment(Environment environment) {
		
		if(getName().contentEquals("ireturn") || getName().contentEquals("areturn")){
			
			try {
				environment.popStack();
			} catch (BEException e) {
				e.printStackTrace();
				System.exit(1);
			}
			
		}else if(getName().contentEquals("return")){
			
			//ritorna semplicemente
			
		}
		
	}

}
