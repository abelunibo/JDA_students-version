package com.laneve.deadlock.models;

import java.util.HashMap;
import java.util.LinkedList;

public class Environment {
	
	BEConstantPool constantPool;
	LinkedList<String>  operandStack, locks, queuethreads;
	HashMap<String, String> localVar;
		
	public Environment(BEConstantPool costantPool) {
		this.constantPool = costantPool;
	}

	public void openScope() {
		operandStack = new LinkedList<String>();
		locks = new LinkedList<String>();
		queuethreads = new LinkedList<String>();
		localVar = new HashMap<String, String>();
	}

	public void closeScope() {
		operandStack = null;
		locks = null;
		queuethreads = null;		
	}

	public BEConstantPool getConstantPool() {
		return constantPool;
	}

	public void setConstantPool(BEConstantPool constantPool) {
		this.constantPool = constantPool;
	}

	public LinkedList<String> getOperandStack() {
		return operandStack;
	}

	public void setOperandStack(LinkedList<String> operandStack) {
		this.operandStack = operandStack;
	}

	public LinkedList<String> getLocks() {
		return locks;
	}

	public void setLocks(LinkedList<String> locks) {
		this.locks = locks;
	}

	public LinkedList<String> getQueuethreads() {
		return queuethreads;
	}

	public void setQueuethreads(LinkedList<String> queuethreads) {
		this.queuethreads = queuethreads;
	}

	public HashMap<String, String> getLocalVar() {
		return localVar;
	}

	public void setLocalVar(HashMap<String, String> localVar) {
		
	}
	
	public String popStack(){
		String o = null;
		if(!operandStack.isEmpty())
			o = operandStack.removeFirst();
		return o;
	}
	
	public void pushStack(String val){
		operandStack.add(val);
	}

	public void putLocalVar(String localVarIndex, String val) {
		localVar.put(localVarIndex, val);
		
	}
	

}
