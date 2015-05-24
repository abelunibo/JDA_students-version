package com.laneve.deadlock.models.instructions;
import java.util.logging.Logger;

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

		//TODO environment.popStack() potrebbe non esserci nulla sullo stack se 
		//un eccezione a runtime ha inserito un oggetto eccezione e quindi staticamente
		//sullo stack non c'e' nulla quindi l'astore che gestisce l'eccezione tenta di prendere
		//qualcosa che c'e' solo a runtime BOOM !

		//TODO vedi se lo stack e' vuoto se e' questo il caso 
		//TODO vedi se l'istruzione precedente e' un goto BEMEthodBody.getIstruzionePrecedente
		//TODO predi getNat goto e salta all'istruzione specificata dal goto
		try {
			environment.putLocalVar(localVarIndex,environment.popStack());


			if(environment.getOperandStack().isEmpty()){
				if(environment.getCurrentMethodBody().getInstructionTemp().getName() == "goto"){
					String indexTojump = environment.getCurrentMethodBody().getInstructionTemp().getNumber();
					Integer indexListTojump = environment.getCurrentMethodBody().getInstructionMap().get(indexTojump);
					environment.getCurrentMethodBody().setNextGotoInstruction(indexListTojump);
				}

			}else
				environment.putLocalVar(localVarIndex,environment.popStack());
		} catch (BEException e) {
			e.printStackTrace();
		}

	}
}
