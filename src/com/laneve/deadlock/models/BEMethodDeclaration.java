package com.laneve.deadlock.models;

import com.laneve.deadlock.models.lam.LamBase;


public class BEMethodDeclaration extends BEBase{
	BEMethodModifier modifier;
	BEMethodHeader methodHeader;
	BEMethodBody methodBody;
	
	public BEMethodDeclaration(BEMethodModifier modifier,BEMethodHeader methodHeader,BEMethodBody methodBody) {
		this.modifier = modifier;
		this.methodHeader = methodHeader;
		this.methodBody = methodBody;
	}

	public BEMethodModifier getModifier() {
		return modifier;
	}

	public BEMethodHeader getMethodHeader() {
		return methodHeader;
	}

	public BEMethodBody getMethodBody() {
		return methodBody;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		return methodBody.generateLam(environment);
	}

	

}