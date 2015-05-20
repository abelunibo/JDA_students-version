package com.laneve.deadlock.models;

import java.util.HashMap;
import java.util.LinkedList;

public class BEClassFile extends BEBase{
	String className;
	BEConstantPool costantPool;
	HashMap<String, LinkedList<String>> methods;


	public BEClassFile(String className,BEConstantPool costantPool) {
		super();
		this.className = className;
		this.costantPool = costantPool;
	}

	public void addMethod(BEMethodDec methodDec){

	}

	public String getClassName() {
		return className;
	}

	public BEConstantPool getCostantPool() {
		return costantPool;
	}
}
