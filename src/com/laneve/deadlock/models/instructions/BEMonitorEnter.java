package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.exceptions.BEException;
import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.type.TypeObject;
import com.laneve.deadlock.models.lam.LamZT;

public class BEMonitorEnter extends BEInstructionLine implements BEInstruction{

	
	public BEMonitorEnter(String text) {
		instructionName = text;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		LamBase lzt = new LamZT();		
		LamZT.addDebugZT(environment);
		String lamZ = LamZT.getZhatBar(environment.getLocks());
		String lamT = LamZT.getThat(environment.getQueuethreads());	
		lzt.setLam(lamZ+" & "+lamT);
		changeEnvironment(environment);		
		return lzt;
	}

	@Override
	public void changeEnvironment(Environment environment) {
		TypeObject topStack=null;
		try {
			topStack = (TypeObject) environment.popStack();
		} catch (BEException e) {
			e.printStackTrace();
			System.exit(1);
		}
		environment.addLock(topStack);
	}

}
