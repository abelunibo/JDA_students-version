package com.laneve.deadlock.models;

import java.util.HashMap;

public class BEClassFile extends BEBase{
	String className;

	HashMap<String, String> methods = new HashMap<String, String>();

	public BEClassFile(String name){
		this.className = name;
	}
	
	public String getName(){
		return className;
	}
}
