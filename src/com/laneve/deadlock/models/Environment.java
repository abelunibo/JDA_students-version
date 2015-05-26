package com.laneve.deadlock.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import com.laneve.bytecode.parser.BytecodeParser.FormalParameterContext;
import com.laneve.deadlock.exceptions.BEException;
import com.laneve.deadlock.type.Type;
import com.laneve.deadlock.type.TypeInt;
import com.laneve.deadlock.type.TypeObject;

public class Environment {
	BEConstantPool constantPool;
	String className;
	LinkedList<Type>  operandStack, locks, queueThreads;
	HashMap<String, Type> localVar; //TODO sarebbe piu' conforme alle specifiche se fosse un arraylist
	BEMethodBody currentMethodBody;
	private LinkedHashMap<String, LinkedHashMap<String, String>> fields;

	public Environment(LinkedHashMap<String, LinkedHashMap<String, String>> fields,
			BEConstantPool costantPool, String className) {
		this.constantPool = costantPool;	
		this.className = className;
		this.fields = fields;
	}
	
	public LinkedHashMap<String, LinkedHashMap<String, String>> getFields() {
		return fields;
	}
	public String getClassName(){
		return className;
	}

	public BEMethodBody getCurrentMethodBody(){
		return currentMethodBody;
	}

	public void openScope(BEMethodBody mb) {

		//inizializza le strutture
		operandStack = new LinkedList<Type>();
		locks = new LinkedList<Type>();
		queueThreads = new LinkedList<Type>();
		localVar = new HashMap<String, Type>();
		currentMethodBody=mb;

		if(mb.getMethodModifier() != null && 
				mb.getMethodModifier().getModifier().contains("synchronized")){ 
			// se metodo e' synchronized  aggiungi il this ai lock
			addLock(new TypeObject(className,0));  //il this e' il primo parametro quindi e' indicizzato a 0
		}

		//setta i parametri nelle corrispondenti posizioni della localVar
		ArrayList<FormalParameterContext> pars=null;
		try {
			pars = mb.getMethodHeader().getMethodDeclarator().getFormalParameters();
		} catch (BEException e) {
			e.printStackTrace();
			System.exit(1);
		}	

		int j=0;

		if(mb.getMethodModifier() != null && 
				!mb.getMethodModifier().getModifier().contains("static")){ //non è un modificatore statico
			//aggiungo il this in posizione 0 delle localVar
			localVar.put("0", new TypeObject(className,j));
			j++;
		}

		for(int i=0;i<pars.size(); i++){
			if(pars.get(i).getText().equals("int")){
				localVar.put(String.valueOf(j), new TypeInt());
			}
			else{
				localVar.put(String.valueOf(j), new TypeObject(pars.get(i).getText(),j));
			}
			j++;
		}

	}

	public void closeScope() {
		operandStack = null;
		locks = null;
		queueThreads = null;
		currentMethodBody=null;
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

	public void addThread(Type t){
		queueThreads.add(t);
	}
	
	public void removeThread(Type t){
		queueThreads.remove(t);
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


	//TODO usata solo per debug
	public void setLocks(LinkedList<Type> z) {
		this.locks=z;
	}

	//TODO usata solo per debug
	public void setQueuethreads(LinkedList<Type> t) {
		this.queueThreads=t;

	}
}	
