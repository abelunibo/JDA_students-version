package com.laneve.deadlock.type;

public abstract class Type {

	String name; 
	boolean isParameter=false;
	boolean isInt=false;
	
	public Type(String name){
		this.name = name;		
	}
	
	public boolean isInt(){
		return isInt;
	}

	public abstract String getName();

}
