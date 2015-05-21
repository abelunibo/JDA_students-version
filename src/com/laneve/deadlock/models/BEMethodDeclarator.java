package com.laneve.deadlock.models;

import java.util.ArrayList;

import com.laneve.bytecode.parser.BytecodeParser.FormalParameterContext;

public class BEMethodDeclarator extends BEBase {
	String methodName;
	ArrayList<FormalParameterContext> formalParameters;
	
	public BEMethodDeclarator(String methodName, ArrayList<FormalParameterContext> formalParameters) {
		this.methodName = methodName;
		this.formalParameters = formalParameters;
	}
	public String getMethodName() {
		return methodName;
	}
	public ArrayList<FormalParameterContext> getFormalParameters() {
		return formalParameters;
	}
		
	
	
}
