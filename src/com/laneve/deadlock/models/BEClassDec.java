package com.laneve.deadlock.models;

import java.util.HashMap;
//potrebbe non servire
public class BEClassDec extends BEBase {
	
	String name;
	public Boolean isPublic;
	public Boolean isThread;

	
	HashMap<String, String> methods = new HashMap<String, String>();
	
	public BEClassDec(String name, HashMap<String, String> methods) {
		super();
		this.name = name;
		this.methods = methods;
	}
}
