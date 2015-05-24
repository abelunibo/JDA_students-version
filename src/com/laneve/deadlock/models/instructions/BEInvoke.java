package com.laneve.deadlock.models.instructions;

import java.util.logging.Logger;

import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.models.lam.LamZT;

public class BEInvoke extends BEInstructionLine implements BEInstruction{
	private String signature;
	private static Logger LOGGER = Logger.getLogger(BEInvoke.class.getSimpleName());
	
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
			LOGGER.info(environment.takeCpoolRef(getRef()));
			
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
