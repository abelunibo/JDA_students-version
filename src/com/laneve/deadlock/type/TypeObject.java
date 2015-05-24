package com.laneve.deadlock.type;

import com.laneve.deadlock.exceptions.BEException;

public class TypeObject extends Type{

	Integer index = null;
	boolean isParameter=false;
	boolean isField=false;
	
	//crea tipo oggetto per i parametri dei metodi
	public TypeObject(String name, Integer index){
		super(name);
		this.index=index;
		this.isParameter=true;
	}
	
	public TypeObject(String name){
		super(name);
	}
	
	public boolean isParameter(){
		return isParameter;
	}
	
	public boolean isField(){
		return isField;
	}
	
	//crea il tipo univoco per i campi
	// fieldObj e' il tipo del campo
	//field e' il nome del campo
	// o e' il tipo dell'oggetto che contiene il campo
	public TypeObject(TypeObject fieldObj, String field, TypeObject o){
		super(fieldObj.getRawName()+"£"+field+"£"+o.getName());
		this.isField=true;
	}
		
	public void setIndex(Integer index) throws BEException{
		if(this.index!=null) throw new BEException("Non puoi riassegnare un indice ad un tipo");
		this.index=index;
	}
	
	public Integer getIndex(){
		return this.index;
	}
	
	@Override
	public Type dup(Integer dupInstructionIndex){
		if(index==null && !isField){
			try {
				setIndex(dupInstructionIndex); //aggiorno il mio indice
			} catch (BEException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		return dup(this);
	}
	
	private TypeObject dup(TypeObject t){
		TypeObject t1 = new TypeObject(t.name);
		t1.isField=t.isField;
		t1.isParameter=t.isParameter;
		t1.index=t.index;
		return t1;
	}
	
	@Override
	public Type load(Integer loadInstructionIndex){
		if(index==null && !isField){
			try {
				setIndex(loadInstructionIndex); //aggiorno il mio indice
			} catch (BEException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		return this;
	}
	
	
	//ritorna il nome raw del tipo
	public String getRawName() {
		return name;
	}
	
	@Override
	public String getName(){
		return getIndexName();
	}
	
	//ritorna il nome del tipo indicizzato
	private String getIndexName() {
		
		if(isField) return name;
		
		String s=name;
		
		if(isParameter){ //notazione per tipi parametri dei metodi (se e' un parametro di un metodo ha per forza un indice)
			s+= "[" + index + "]";
		}
		else{ //notazione per tipo indicizzato
			if(index!=null){
				s+= "?"+index+"?";
			}
		}
			
		return s;
	}
	
	
	public boolean equals(Object obj) {
		if (!(obj instanceof TypeObject))
			return false;	
		if (obj == this)
			return true;
		return this.getIndexName().equals(((TypeObject) obj).getIndexName());
	}
 
	public int hashCode(){
		return getIndexName().hashCode();
	}
	
	
}
