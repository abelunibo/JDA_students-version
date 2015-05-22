package com.laneve.deadlock.models.instructions;
import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.utilities.Logger;

public class BEStore extends BEInstructionLine implements BEInstruction{
	private String localVarIndex;
	private String val;
	
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
		String valtemp = environment.popStack();
		if(getName().contentEquals("astore")){
			localVarIndex = getNat();
		}else if(getName().contentEquals("istore")){
			localVarIndex = getNat();
		}else if(getName().contains("istore_")){
			localVarIndex = getName().substring(getName().indexOf("_")+1, getName().length());
		}else if(getName().contains("astore_")){
			localVarIndex = getName().substring(getName().indexOf("_")+1, getName().length());
		}
		val = getNat() == null ? val = valtemp : "INT" ;
		environment.putLocalVar(localVarIndex,val);
		Logger.logInfo(environment.getLocalVar().get(localVarIndex));
	}
}
