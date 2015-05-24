package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.models.lam.LamZT;
import com.laneve.deadlock.type.TypeInt;
import com.laneve.deadlock.type.TypeObject;

public class BEConst extends BEInstructionLine implements BEInstruction{
	
	public BEConst(String text) {
		instructionName = text;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		LamBase lzt = new LamZT();		
		String lamZ = LamZT.getZhatBar(environment.getLocks());
		String lamT = LamZT.getThat(environment.getQueuethreads());	
		lzt.setLam(lamZ+" & "+lamT);
		changeEnvironment(environment);		
		return lzt;

	}

	@Override
	public void changeEnvironment(Environment environment) {
		
		if(getName().contains("iconst_") || getName().equals("bipush")){
			environment.pushStack(new TypeInt());
		}else if(getName().equals("aconst_null")){
			environment.pushStack(new TypeObject("null"));
		}else if(getName().contains("ldc")){
			String cpType = environment.takeCpoolRefType(getRef());
			if(cpType.equals("Integer"))
				environment.pushStack(new TypeInt());
			else
				environment.pushStack(new TypeObject(environment.takeCpoolRef(getRef())));
		}
	}

}
