package com.laneve.deadlock.type;

public class TypeInt extends Type {

	//costruttore per il tipo degli interi
	public TypeInt(){
		super("INT");
		isInt=true;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Type dup(Integer dupInstructionIndex) {
		return this;
	}

	@Override
	public Type load(Integer loadInstructionIndex) {
		return this;
	}
	
}
