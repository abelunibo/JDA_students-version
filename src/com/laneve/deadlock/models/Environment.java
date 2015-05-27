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
	LinkedHashMap<String, Type> localVar; 
	BEMethodBody currentMethodBody;
	private LinkedHashMap<String, LinkedHashMap<String, Type>> fields;
	
	//Teniamo traccia di come è state tipata la signature del metodo
	private String currentMethodsLAMSignature;

	
	public Environment(LinkedHashMap<String, LinkedHashMap<String, Type>> fields,
			BEConstantPool costantPool, String className) {
		this.constantPool = costantPool;	
		this.className = className;
		this.fields = fields;	
	}
	
	public LinkedHashMap<String, LinkedHashMap<String, Type>> getFields() {
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
		localVar = new LinkedHashMap<String, Type>();
		currentMethodBody=mb;

		ArrayList<Type> aType= new ArrayList<Type>();
		
		TypeObject t=new TypeObject(className,fields,true); //il this del metodo
		aType.add(t);
		
		//recupero il nome del metodo
		String methodName="";
		try {
			methodName = mb.getMethodHeader().getMethodDeclarator().getMethodName();
		} catch (BEException e1) {
			e1.printStackTrace();
		}
		
		//controllo se metodo synchronized
		if(mb.getMethodModifier() != null && 
				mb.getMethodModifier().getModifier().contains("synchronized")){ 
			// se metodo e' synchronized  aggiungi il tipo del this ai lock
			addLock(t);  
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
				!mb.getMethodModifier().getModifier().contains("static")){ //non ha un modificatore statico
			//aggiungo il this in posizione 0 delle localVar
			localVar.put("0", t);
			j++;
		}

		for(int i=0;i<pars.size(); i++){
			Type t1=null;
			if(pars.get(i).getText().equals("int")){
				t1=new TypeInt();
				localVar.put(String.valueOf(j),t1);
			}
			else{
				t1= new TypeObject(pars.get(i).getText(),fields,true);
				localVar.put(String.valueOf(j), t1);
			}
			
			aType.add(t1);
			
			j++;
		}
		
		
		//creo la signature per la LAM del metodo
		
		String mName=methodName;
		if(!methodName.contains(".") && !methodName.contains("/") && !methodName.equals("main")) //il metodo main deve essere unico
			mName=className+"."+mName;
	
		String mSignature=mName.toUpperCase() + "(";
		
		int k=0;
		
		for(int i =0; i<aType.size() ;i++){
		
			if(aType.get(i).isInt()) //i tipi interi non li mettiamo nella signature dei metodi
				continue;
			else{
				mSignature+=TypeObject.flattenedFields(((TypeObject)aType.get(i)), "", "")+", ";
				k++;
			}
		}

		if(j>0)
			mSignature = mSignature.substring(0, mSignature.lastIndexOf(",")); //rimuovo l'ultima virgola
		mSignature+=")";

		currentMethodsLAMSignature = mSignature;
		System.out.println(mSignature);
	}

	
	public void closeScope() {
		operandStack = null;
		locks = null;
		queueThreads = null;
		currentMethodBody=null;
		currentMethodsLAMSignature=null;
	}
	
	
	public String getCurrentMethodLAMSignature(){
		
		return currentMethodsLAMSignature;
		
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
