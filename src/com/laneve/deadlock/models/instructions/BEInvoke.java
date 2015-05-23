package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.exceptions.BEException;
import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.models.lam.LamZT;
import com.laneve.deadlock.utilities.Logger;

public class BEInvoke extends BEInstructionLine implements BEInstruction{
	private String signature;
	
	public BEInvoke(String text) {
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
		if(getName().contentEquals("invokespecial")){
			//((v di new) parametri) <init>
		}
		else if(getName().contentEquals("invokevirtual")){
			
			
		}
		else if(getName().contentEquals("invokestatic")){
			
			
			
		}
		
		
		/*try {
			signature = environment.popStack();
		} catch (BEException e) {
			e.printStackTrace();
			System.exit(1);
		}*/
		
	}

}
