package com.laneve.deadlock.models;

import java.util.HashMap;

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

}
