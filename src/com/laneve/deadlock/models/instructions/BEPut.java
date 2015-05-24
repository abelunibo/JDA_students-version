package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.exceptions.BEException;
import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.models.lam.LamZT;
import com.laneve.deadlock.type.TypeObject;

public class BEPut extends BEInstructionLine implements BEInstruction{

	public BEPut(String text) {
		instructionName = text;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		LamBase lzt = new LamZT();		
		LamZT.addDebugZT(environment);
		String lamZ = LamZT.getZhatBar(environment.getLocks());
		String lamT = LamZT.getThat(environment.getQueuethreads());	
		lzt.setLam(lamZ+" & "+lamT);
	//	Logger.logInfo(lzt.getLam());
		try {
			changeEnvironment(environment);
		} catch (BEException e) {
			e.printStackTrace();
			System.exit(1);
		}		
		return lzt;
	}

	@Override
	public void changeEnvironment(Environment environment) throws BEException {
		
		if(getName().equals("putfield")){
			//non si puo' modificare il campo della classe se non siamo nella sua init
			if(!((TypeObject)(environment.getOperandStack().get(1))).getRawName().equals(environment.getClassName())){ 
				throw new BEException("Non si possono modificare campi gia' inizializzati");
			}
			try {
				environment.popStack(2);
			} catch (BEException e) {
				e.printStackTrace();
				System.exit(1);
			}
			
		}else if(getName().equals("putstatic")){
			//non si può modificare il campo statico se non siamo nel blocco statico
			if(environment.getCurrentMethodBody().getMethodHeader().getMethodDeclarator().getMethodName().contains("staticBlock?")){ 
				throw new BEException("Non si possono modificare campi statici al di fuori del loro blocco statico");
			}
			try {
				environment.popStack();
			} catch (BEException e) {
				e.printStackTrace();
				System.exit(1);
			}	
		}	
	}
}
