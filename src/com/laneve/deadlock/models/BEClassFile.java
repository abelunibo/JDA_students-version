package com.laneve.deadlock.models;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.logging.Logger;

import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.models.lam.LamSequence;
import com.laneve.deadlock.exceptions.BEException;

public class BEClassFile extends BEBase{
	String className;
	BEConstantPool costantPool;
	HashMap<BEMethodHeader, BEMethodDeclaration> methods = new HashMap<BEMethodHeader, BEMethodDeclaration>();
	
	//private static Logger LOGGER = Logger.getLogger("");

	public BEClassFile(String className,BEConstantPool costantPool) {
		super();
		this.className = className;
		this.costantPool = costantPool;
	}
	
	public void addMethod(BEMethodDeclaration methodDec) throws BEException {
		if(methods.containsKey(methodDec.getMethodHeader())){ //NON DOVREBBE SUCCEDERE
			throw new BEException("Due metodi con lo stesso header dentro lo stesso classfile");
		}
		methods.put(methodDec.getMethodHeader(), methodDec);
		
	}
	
	public String getClassName() {
		return className;
	}

	public BEConstantPool getCostantPool() {
		return costantPool;
	}

	public HashMap<BEMethodHeader, BEMethodDeclaration> getMethods() {
		return methods;
	}
		
	@Override
	public LamBase generateLam(Environment environment) {
		LamSequence l = new LamSequence();
		for(Entry<BEMethodHeader, BEMethodDeclaration> m : methods.entrySet()){
			BEMethodDeclaration methodDeclaration = m.getValue();
			LamBase lam = methodDeclaration.generateLam(environment);
//			LOGGER.info("-------------------------------------------------------------------------------\n");
//			LOGGER.info("Method Lam:\t"+lam.getLam()+"\n");
//			l.createSequence(lam);
//			
//			LOGGER.info("-------------------------------------------------------------------------------\n");
//			LOGGER.info(" FINE metodo "+ m.getKey().getMethodDeclarator().getMethodName() +"\t\t|\tclasse " +
//						environment.getClassName()+"\n");
//			LOGGER.info("-------------------------------------------------------------------------------\n");
		}
		

		
		return l;
	}
}
