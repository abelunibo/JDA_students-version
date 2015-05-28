package com.laneve.deadlock.type;

import com.laneve.deadlock.exceptions.BEException;

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
	
	// assegna un indice ad un tipo (se possibile) e restituisci il tipo appena indicizzato
	public abstract Type assignIndex() throws BEException;

	
}
