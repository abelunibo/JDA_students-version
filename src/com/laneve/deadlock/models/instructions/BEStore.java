package com.laneve.deadlock.models.instructions;
import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;

public class BEStore extends BEInstructionLine implements BEInstruction{
	private String localVarIndex;
	
	public BEStore(String text) {
		instructionName = text;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		handleEnvironment(environment);
		return super.generateLam(environment);
	}
	
	@Override
	public void handleEnvironment(Environment environment) {
		if(getName().contentEquals("astore")){
			localVarIndex = getNat();
		}else if(getName().contentEquals("istore")){
			localVarIndex = getNat();
		}else if(getName().contains("istore_")){
			localVarIndex = getName().substring(getName().indexOf("_")+1, getName().length());
		}else if(getName().contains("astore_")){
			localVarIndex = getName().substring(getName().indexOf("_")+1, getName().length());
		}
//		environment.putLocalVar(localVarIndex,environment.popStack());
//		Logger.logInfo(environment.getLocalVar().get(localVarIndex));
	}
}
