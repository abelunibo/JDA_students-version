package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.exceptions.BEException;
import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.models.lam.LamZT;

public class BEMonitorExit extends BEInstructionLine implements BEInstruction{

	public BEMonitorExit(String text) {
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
		try {
			environment.popStack();
			environment.removeLock();
		} catch (BEException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}


}
