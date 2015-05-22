package com.laneve.deadlock.models;

import java.util.HashMap;
import java.util.Map.Entry;

import com.laneve.deadlock.models.lam.LamBase;

public class BEClassFile extends BEBase{
	String className;
	BEConstantPool costantPool;
	HashMap<BEMethodHeader, BEMethodDeclaration> methods = new HashMap<BEMethodHeader, BEMethodDeclaration>();


	public BEClassFile(String className,BEConstantPool costantPool) {
		super();
		this.className = className;
		this.costantPool = costantPool;
	}
	
	public void addMethod(BEMethodDeclaration methodDec) {
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
		LamBase l = null;
		for(Entry<BEMethodHeader, BEMethodDeclaration> m : methods.entrySet()){
			BEMethodDeclaration methodDeclaration = m.getValue();
			l = methodDeclaration.generateLam(environment);
		}
		return l;
	}

}
