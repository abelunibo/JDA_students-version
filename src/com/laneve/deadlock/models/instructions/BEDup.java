package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.exceptions.BEException;
import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.models.lam.LamZT;

public class BEDup extends BEInstructionLine implements BEInstruction{

	public BEDup(String text) {
		instructionName = text;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		LamBase lzt = new LamZT();		
		String lamZ = LamZT.getZhatBar(environment.getLocks());
		String lamT = LamZT.getThat(environment.getQueuethreads());	
		lzt.setLam(lamZ+" & "+lamT);
		updateEnvironment(environment);		
		return lzt;
	}

	@Override
	public void updateEnvironment(Environment environment) {
		String index = getIndex().substring(0,getIndex().indexOf(':'));
		try {
			environment.pushStack(environment.getTopStack().dup(Integer.valueOf(index)));
		} catch (BEException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}


}
