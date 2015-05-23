package com.laneve.deadlock.models.instructions;

import java.util.LinkedList;

import com.laneve.deadlock.exceptions.BEException;
import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.models.lam.LamZT;
import com.laneve.deadlock.utilities.Logger;

public class BEOperation extends BEInstructionLine implements BEInstruction{

	public BEOperation(String text) {
		instructionName = text;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		LamZT lzt = new LamZT();
		
		LinkedList<String> z = new LinkedList<String>();
		z.add("a");
		z.add("b");
		z.add("c");
		z.add("b"); 
		z.add("d");
		z.add("c");
		z.add("c");
		z.add("a");
		z.add("e");
		z.add("c"); //l'ultimo lock preso e' in fondo alla lista
	
		LinkedList<String> t = new LinkedList<String>();
		t.add("p");
		t.add("q");
		t.add("r");
		
		environment.setLocks(z);
		environment.setQueuethreads(t);
		
		String lamZ = LamZT.getZhatBar(environment.getLocks());
		String lamT = LamZT.getThat(environment.getQueuethreads());	
		
		lzt.setLam(lamZ+" & "+lamT);
		
		Logger.logInfo(lzt.getLam());
		
		handleEnvironment(environment);
		return super.generateLam(environment);
	}

	@Override
	public void handleEnvironment(Environment environment) {

		try {
			environment.popStack(2);
		} catch (BEException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		environment.pushStack("INT");
		
	}


}
