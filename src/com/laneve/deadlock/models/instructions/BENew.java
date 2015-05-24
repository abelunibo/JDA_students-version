package com.laneve.deadlock.models.instructions;

import java.util.logging.Logger;

import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.type.TypeObject;
import com.laneve.deadlock.models.lam.LamZT;

public class BENew extends BEInstructionLine implements BEInstruction{

	public BENew(String text) {
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
		System.out.println(environment.takeCpoolRef(getRef()));
		environment.pushStack(new TypeObject(environment.takeCpoolRef(getRef())));
	}
}
