package com.laneve.deadlock.models;

import java.util.HashMap;

public class BEClassDec extends BEBase {
	
	String name;
	
	HashMap<String, String> methods = new HashMap<String, String>();
	
	public BEClassDec(String name, HashMap<String, String> methods) {
		super();
		this.name = name;
		this.methods = methods;
	}

	@Override
	public String getName() {
		return name;
	}
}
