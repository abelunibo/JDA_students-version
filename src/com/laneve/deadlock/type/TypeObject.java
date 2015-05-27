package com.laneve.deadlock.type;

import java.util.LinkedHashMap;
import java.util.Map;

import com.laneve.deadlock.exceptions.BEException;


/** Tipo oggetto */
public class TypeObject extends Type{

	/* campo usato per generare i tipi fresh */
	static private int indexCounter = 1;
	
	/* specifica la profondità di ricorsione sui campi nell'espansione dei tipi */
	static final private int DEPTH = 2;
	
	Integer index = null; //indice null se oggetto non ha index
	
	//ogni tipo oggetto ha un insieme di campi che hanno un nome e un tipo
	LinkedHashMap <String,Type> fieldsRecord=null; 
	
	//tipo che non puo' essere indicizzato e la cui stampa non includera' i campi
	private boolean isRawTypeObject = false;
	
	// costruttore di default per i tipi oggetto
	// il primo parametro e' il nome della classe del tipo da creare (senza indice, preso dalla constantPool al momento della new)
	// il secondo parametro è la mappa che conosce i campi di una classe
	public TypeObject(String className, LinkedHashMap<String,LinkedHashMap<String,Type>> fields, boolean initializedFields){
		super(className);
		fieldsRecord = new LinkedHashMap <String,Type>();
				try { //setto il suo indice fittizio
					setIndex();
				} catch (BEException e) { // non si puo' mai verificare, il tipo e' appena stato creato --> non ha ancora un indice
					e.printStackTrace();
				}
				if(initializedFields)
					setFieldsRecursion(this, fields, DEPTH, true);
				else
					setFieldsRecursion(this, fields, DEPTH, false);
	}
	
	
	/** Crea un oggetto di tipo NULL*/
	public TypeObject(){
		super("NULL");
		fieldsRecord = new LinkedHashMap <String,Type>(); //evita problemi di null pointer
	}
	
	
	// usato solo da metodo getRawTypeObject
	private TypeObject(String className){
		super(className);
		isRawTypeObject=true;
	}
	
	/* ritorna un oggetto che identifica una classe */
	public static TypeObject getRawTypeObject(String className){
		TypeObject t = new TypeObject(className);
		return t;
	}
	
	private LinkedHashMap <String,Type> getFieldsRecord(){
		return fieldsRecord;
	}
	
	/* costruttore utilizzato solo con funzione setFieldsRecursion*/
	private TypeObject(String className,LinkedHashMap<String,LinkedHashMap<String,Type>> fields,
			int depth,boolean initializedFields){
		super(className);
		fieldsRecord = new LinkedHashMap <String,Type>();
		setFieldsRecursion(this, fields, depth-1,initializedFields);
	}
	
	// setta tutti i tipi dei campi di quest'oggetto ad un tipo fittizio oppure a null (non inizializzati)
	// a seconda del valore initializedFields
	private static void setFieldsRecursion(TypeObject startType, 
			final LinkedHashMap<String,LinkedHashMap<String,Type>> fields, int depth, boolean initializedFields){
		
		if (depth==0) return; //termina ricorsione

		if(fields.get(startType.getRawName())!=null){ //abbiamo la classe nella nostra mappa
			LinkedHashMap<String,Type> typeFields = new LinkedHashMap <String,Type>(fields.get(startType.getRawName()));
		    for(Map.Entry<String, Type> entry : typeFields.entrySet()){
				if(entry.getValue().isInt()) continue; //interi considerati sempre inizializzati
				else{ //campo oggetto
					TypeObject t =null;
					
					if(initializedFields){
						//vengono creato un nuovo oggetto ognuno con un nuovo indice
						t = new TypeObject(((TypeObject)entry.getValue()).getRawName(), fields, depth,initializedFields); 
						try {
							t.setIndex(); //indice fittizio
						} catch (BEException e) {
							e.printStackTrace();
							System.exit(1);
						} 
					}
					
					entry.setValue(t);
				}
				
			}
		    
			startType.fieldsRecord=typeFields; // tra i campi vi sono salvati anche quelli di tipo INT

		}
		
	}
	
	
	// ritorna la stringa che rappresenta il tipo t comprensivo dei campi visitati ricorsivamente
		private static String typeAndFields(TypeObject t, int depth){		
				
				if(t == null) return "⊥";
				
				String s = t.getIndexName();
				if(!t.getFieldsRecord().isEmpty()){
					s+="[";
					for(Map.Entry<String, Type> entry : t.getFieldsRecord().entrySet()){
						String fieldName=entry.getKey(); //nome campo
						if(entry.getValue()!=null && entry.getValue().isInt()) continue; //evito gli INT
						else{	
							s+=fieldName+ " : ";
							s+= typeAndFields(((TypeObject)entry.getValue()),depth-1)+", " ;	
						}
					}
					s= s.substring(0, s.lastIndexOf(",")); //rimuovo l'ultima virgola
					s+="]";
				}
				
				return s;
		}
		
		
		// ritorna una stringa che rappresenta la vista appiattita dei campi dell'oggetto di tipo t
		public static String flattenedFields(TypeObject t, String leftSeparator, String rightSeparator){		
			
				if (leftSeparator == ""){
					leftSeparator = "->"; //separatore di defalut
				}
				
				if (rightSeparator == ""){
					rightSeparator = ":"; //separatore di defalut
				}
				
				if(t == null) return "⊥";
				
				String s = t.getIndexName() +", ";
				if(!t.getFieldsRecord().isEmpty()){
					for(Map.Entry<String, Type> entry : t.getFieldsRecord().entrySet()){
						String fieldName=entry.getKey(); //nome campo
						if(entry.getValue()!=null && entry.getValue().isInt()) continue; //evito gli INT
						else{
							s+= t.getIndexName()+leftSeparator+fieldName+rightSeparator+flattenedFields(((TypeObject)entry.getValue()),leftSeparator,rightSeparator)+", " ;	
						}
					}
				}
				s= s.substring(0, s.lastIndexOf(",")); //rimuovo l'ultima virgola
				return s;
		}
	
	
	/* setta il tipo di un campo di questo oggetto (possibile solo se si assegna lo stesso tipo
	 * o se il campo non era stato inizializzato) */
	public void setFieldType(String fieldName, Type fieldType) throws BEException{
		if(!fieldType.isInt() && this.fieldsRecord.get(fieldName)!=null &&
				!this.fieldsRecord.get(fieldName).equals((TypeObject)fieldType))
			throw new BEException("Non puoi modificare un campo gia' inizializzato");
		else if (!fieldType.isInt() && fieldType != null){
			this.fieldsRecord.put(fieldName, fieldType);
		}
		//altrimenti non devo fare niente (i campi INT sono da subito settati a INT e mai a bottom)
	}
	
	/* ritorna il tipo di un campo*/
	public Type getFieldType(String fieldName){
		return fieldsRecord.get(fieldName);
	}
	
	/* ritorna la mappa con tutti i campi dell'oggetto */
	public LinkedHashMap<String,Type> getObjectFields(){
		return fieldsRecord;
	}

	// setta un indice fresh per questo tipo
	private void setIndex() throws BEException{
		if(this.index!=null) throw new BEException("Non puoi riassegnare un indice ad un tipo");
		if(!isRawTypeObject)
			this.index=TypeObject.getFreshIndex();
	}
	
	//ritorna l'indice di questo tipo o null se questo tipo non è indicizzato
	public Integer getIndex(){
		return this.index;
	}
	
	
	@Override
	public TypeObject assignIndex(){
		if(index==null){
			try {
				setIndex(); //aggiorno il mio indice
			} catch (BEException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		return this;
	}
	
	
	//ritorna il nome raw del tipo
	public String getRawName() {
		return className;
	}
	
	@Override
	public String getName(){
		if(!isRawTypeObject)
			return typeAndFields(this,DEPTH);
		else
			return className; //tipi nella tabella globale dei campi
	}
	
	
	//ritorna il nome del tipo indicizzato
	public String getIndexName() {
				
		String s=this.className;
		
		if(index!=null)
			s+= "?"+index+"?";
			
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
	
		
	// ritorna un indice fresh
	static int getFreshIndex(){
		return indexCounter++;
	}
	
}
