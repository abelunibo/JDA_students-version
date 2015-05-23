package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.utilities.Logger;

public class BELoad extends BEInstructionLine implements BEInstruction{
	private String localVarIndex;

	public BELoad(String text) {
		instructionName = text;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		handleEnvironment(environment);
		return super.generateLam(environment);
	}

	@Override
	public void handleEnvironment(Environment environment) {
		if(getName().contentEquals("aload")){
			localVarIndex = getNat();
		}else if(getName().contentEquals("iload")){
			localVarIndex = getNat();
		}else if(getName().contains("iload_")){
			localVarIndex = getName().substring(getName().indexOf("_")+1, getName().length());
		}else if(getName().contains("aload_")){
			localVarIndex = getName().substring(getName().indexOf("_")+1, getName().length());
		}
		environment.pushStack(environment.getLocalVar().get(localVarIndex));
		Logger.logInfo(environment.getLocalVar().get(localVarIndex));
	}
}
