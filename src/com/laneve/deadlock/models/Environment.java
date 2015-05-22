package com.laneve.deadlock.models;

import java.util.LinkedList;

public class Environment {
	
	BEConstantPool constantPool;
	LinkedList<String>  operandStack, locks, queuethreads;
		
	public Environment(BEConstantPool costantPool) {
		this.constantPool = costantPool;
	}

	public void openScope() {
		operandStack = new LinkedList<String>();
		locks = new LinkedList<String>();
		queuethreads = new LinkedList<String>();
	}

	public void closeScope() {
		operandStack = null;
		locks = null;
		queuethreads = null;		
	}

	protected BEConstantPool getConstantPool() {
		return constantPool;
	}

	protected void setConstantPool(BEConstantPool constantPool) {
		this.constantPool = constantPool;
	}

	protected LinkedList<String> getOperandStack() {
		return operandStack;
	}

	protected void setOperandStack(LinkedList<String> operandStack) {
		this.operandStack = operandStack;
	}

	protected LinkedList<String> getLocks() {
		return locks;
	}

	protected void setLocks(LinkedList<String> locks) {
		this.locks = locks;
	}

	protected LinkedList<String> getQueuethreads() {
		return queuethreads;
	}

	protected void setQueuethreads(LinkedList<String> queuethreads) {
		this.queuethreads = queuethreads;
	}
	
}
