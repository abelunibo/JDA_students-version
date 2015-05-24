package com.laneve.deadlock.type;

public abstract class Type {

	String name; 
	boolean isInt=false;
	
	public Type(String name){
		this.name = name;		
	}
	
	public boolean isInt(){
		return isInt;
	}

	public abstract String getName();
	
	// ritorna una copia del tipo eseguita con una dup 
	public abstract Type dup(Integer dupInstructionIndex);
	
	//ritorna il tipo caricato con una load
	public abstract Type load(Integer loadInstructionIndex);

}
