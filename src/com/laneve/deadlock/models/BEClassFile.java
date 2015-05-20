package com.laneve.deadlock.models;

import java.util.HashMap;

public class BEClassFile extends BEBase{
	String className;
	BEClassDec classDec;
	BECostantPool costantPool;
	HashMap<String, String> methods;

	
	public BEClassFile(String className, BEClassDec classDec,
			BECostantPool costantPool) {
		
		super();
		methods = new HashMap<String, String>();
		this.className = className;
		this.classDec = classDec;
		this.costantPool = costantPool;
	}
	
	public void addMethod(BEMethodDec methodDec){
		
	}
	
}
