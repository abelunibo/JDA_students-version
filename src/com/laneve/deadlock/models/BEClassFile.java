package com.laneve.deadlock.models;

import java.util.HashMap;
import java.util.Map.Entry;

import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.models.lam.LamSequence;
import com.laneve.deadlock.exceptions.BEException;

public class BEClassFile extends BEBase{
	String className;
	BEConstantPool costantPool;
	HashMap<BEMethodHeader, BEMethodDeclaration> methods = new HashMap<BEMethodHeader, BEMethodDeclaration>();

	public BEClassFile(){
		
	}

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
			l.createSequence(methodDeclaration.generateLam(environment));
		}
		return l;
	}
}
