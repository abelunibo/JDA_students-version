package com.laneve.deadlock.type;

public abstract class Type {
			
	String className=""; // nome della classe del tipo
	
	boolean isInt=false; 	// true per interi
	
	public Type(String name){
		this.className = name;		
	}
	
	public boolean isInt(){
		return isInt;
	}

	public abstract String getName();
	
	// assegna un indice ad un tipo e restituiscilo
	public abstract Type assignIndex();

	
}
