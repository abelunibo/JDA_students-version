package com.laneve.deadlock.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import com.laneve.deadlock.exceptions.BEException;
import com.laneve.deadlock.type.Type;

public class Environment {
	
	BEConstantPool constantPool;
	LinkedList<Type>  operandStack, locks, queueThreads;
	HashMap<String, Type> localVar;
		
	public Environment(BEConstantPool costantPool) {
		this.constantPool = costantPool;
	}

	public void openScope() {
		operandStack = new LinkedList<Type>();
		locks = new LinkedList<Type>();
		queueThreads = new LinkedList<Type>();
		localVar = new HashMap<String, Type>();
	}

	public void closeScope() {
		operandStack = null;
		locks = null;
		queueThreads = null;		
	}

	public BEConstantPool getConstantPool() {
		return constantPool;
	}

	public void setConstantPool(BEConstantPool constantPool) {
		this.constantPool = constantPool;
	}

	public LinkedList<Type> getOperandStack() {
		return operandStack;
	}

	public LinkedList<Type> getLocks() {
		return locks;
	}

	public void addLock(Type lock){
		this.locks.add(lock);
	}
	
	public Type removeLock() throws BEException{
		Type o = null;
		if(!locks.isEmpty())
			o = locks.removeLast();
		//else throw new BEException("rimozione da pila dei lock vuota"); TODO rimetterlo
		return o;
	}
	
	public LinkedList<Type> getQueuethreads() {
		return queueThreads;
	}


	public HashMap<String, Type> getLocalVar() {
		return localVar;
	}

	
	//recupera il valore in cima allo stack senza rimuoverlo
	public Type getTopStack() throws BEException{
		Type o;
		if(!operandStack.isEmpty())
			o=operandStack.getLast();
		else throw new BEException("recupero valore da operand stack vuoto");
		
		return o;
	}
	
	public Type popStack() throws BEException {
		Type o = null;
		if(!operandStack.isEmpty())
			o = operandStack.removeLast();
		//else throw new BEException("pop da operand stack vuoto"); TODO rimetterlo
		return o;
	}
	//pop multiplo senza interesse su cosa si è scartato
	public void popStack(int count) throws BEException {

		for(int i = 0; i<count; i++){
			if(!operandStack.isEmpty())
				operandStack.removeLast();
			//else throw new BEException("pop da operand stack vuoto"); //TODO rimetterlo
		}
	}
	public void pushStack(Type val){
		operandStack.add(val);
	}

	public void putLocalVar(String localVarIndex, Type val) {
		localVar.put(localVarIndex, val);
		
	}

	public String takeCpoolRef(String ref) {
		BEConstantAndInfo constantInfo = constantPool.getTableEntries().getTableEntry().get(ref);
		ArrayList<String> a = constantInfo.getConstantAndInfo();
		switch (a.get(0)) {
		case "Class":
			String cRef = a.get(1);
			return takeCpoolRef(cRef);
		default://"Utf8"
			return a.get(1);
		}
	}

	//TODO usata solo per debug
	public void setLocks(LinkedList<Type> z) {
		this.locks=z;
	}

	//TODO usata solo per debug
	public void setQueuethreads(LinkedList<Type> t) {
		this.queueThreads=t;
		
	}
	
	
}	
