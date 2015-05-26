package com.laneve.deadlock.type;

/** Tipo intero */
public class TypeInt extends Type {

	//costruttore per il tipo degli interi
	public TypeInt(){
		super("INT");
		isInt=true; //e' un tipo intero
	}

	@Override
	public String getName() {
		return className;
	}

	@Override
	public TypeInt assignIndex() {
		return this; // un intero non ha alcun indice
	}

	
}
