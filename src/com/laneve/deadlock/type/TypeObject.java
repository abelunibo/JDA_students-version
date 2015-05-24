package com.laneve.deadlock.type;

import com.laneve.deadlock.exceptions.BEException;

public class TypeObject extends Type{

	Integer index = null;
	
	//crea tipo oggetto per i parametri dei metodi
	public TypeObject(String name, Integer index){
		super(name);
		this.index=index;
		this.isParameter=true;
	}
	
	public TypeObject(String name){
		super(name);
	}
		
	public void setIndex(Integer index) throws BEException{
		if(index!=null) throw new BEException("Non puoi riassegnare un indice ad un tipo");
		this.index=index;
	}
	
	public Integer getIndex(){
		return this.index;
	}
	
	
	// ritorna una copia del tipo eseguita con una dup 
	public static TypeObject dup(TypeObject t, Integer dupInstructionIndex){
		if(t.index==null)
			try {
				t.setIndex(dupInstructionIndex);
			} catch (BEException e) {
				e.printStackTrace();
				System.exit(1);
			}
		TypeObject tNew=new TypeObject(t.name);
		tNew.index=t.index;
		return tNew;
	}
	
	
	//ritorna il tipo caricato con una load
	public TypeObject load(Integer loadInstructionIndex){
		if(index==null)
			try {
				setIndex(loadInstructionIndex);
			} catch (BEException e) {
				e.printStackTrace();
				System.exit(1);
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
		
		String s=name;
		
		if(isParameter){ //se e' un parametro di un metodo ha per forza un indice
			s+= "[" + index + "]";
		}
		else{
			
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
