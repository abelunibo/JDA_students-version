package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.exceptions.BEException;
import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.models.lam.LamZT;

public class BEStore extends BEInstructionLine implements BEInstruction{
	private String localVarIndex;
	
	public BEStore(String text) {
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
		if(getName().contentEquals("astore")){
			localVarIndex = getNat();
		}else if(getName().contentEquals("istore")){
			localVarIndex = getNat();
		}else if(getName().contains("istore_")){
			localVarIndex = getName().substring(getName().indexOf("_")+1, getName().length());
		}else if(getName().contains("astore_")){
			localVarIndex = getName().substring(getName().indexOf("_")+1, getName().length());
		}
		  
		try {
			environment.putLocalVar(localVarIndex,environment.popStack());
		} catch (BEException e) {
			e.printStackTrace();
		}

	}
}
