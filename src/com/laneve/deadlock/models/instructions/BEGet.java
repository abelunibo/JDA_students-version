package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.exceptions.BEException;
import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.models.lam.LamZT;
import com.laneve.deadlock.type.TypeObject;

public class BEGet extends BEInstructionLine implements BEInstruction{

	public BEGet(String text) {
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
	public void changeEnvironment(Environment environment){
		if(getName().equals("getfield")){
			TypeObject o = null;
			try {
				o= (TypeObject) environment.popStack(); //tolgo dallo stack elemento da cui devo recuperare il campo
			} catch (BEException e) {
				e.printStackTrace();
				System.exit(1);
			}
			
			//TODO qui i riferimenti vengono presi sicuramente sbagliati....controlla
			environment.pushStack(new TypeObject(new TypeObject(environment.takeCpoolRef(getRef())),environment.takeCpoolRef(getRef()),o));
			
		}else if(getName().equals("getstatic")){
			
			//TODO qui i riferimenti vengono presi sicuramente sbagliati....controlla
			environment.pushStack(new TypeObject(new TypeObject(environment.takeCpoolRef(getRef())),
					environment.takeCpoolRef(getRef()),new TypeObject(environment.takeCpoolRef(getRef()))));

		}
	}
	
}
