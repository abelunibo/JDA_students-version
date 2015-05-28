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
	
	Integer index = null; //indice (null se oggetto non ha index)
	
	// specifica se i campi devono essere appiattiti nell'invocazione di metodo
	// se è false i campi degli vengono mostrati tra parentesi quadre 
	// se e' true i campi vengono mostrati appiattiti cioe' a pari livello dell'oggetto che li contiene
	boolean FLATTEN=true; 
	
	TypeObject parent = null; //se sono un campo tengo traccia del mio tipo padre
	String fieldName = null; //se sono un campo so il mio nome
	
	//ogni tipo oggetto ha un insieme di campi che hanno un nome e un tipo
	LinkedHashMap <String,Type> fieldsRecord=null; 
		
	//viene tenuto un puntatore alla mappa globale dei campi se il tipo di un campo dovra' andare
	//ad esempio a generarsi i suoi sottocampi in futuro
	final LinkedHashMap<String,LinkedHashMap<String,String>> fields;
	
	// tipo che identifica il tipo classe
	// ne esiste uno per ogni classe del programma
	// non puo' essere indicizzato
	// i suoi campi possono essere settati
	private boolean isClassType= false;
	
	// costruttore di default per i tipi oggetto
	// il primo parametro e' il nome della classe del tipo da creare (senza indice, preso dalla constantPool al momento della new)
	// il secondo parametro è la mappa che conosce i campi per i tipi definiti nelle classi bytecode
	// il terzo parametro specifica se i campi vanno inizializzati a valori fittizi (true) oppure a bottom (false)
	public TypeObject(String className, LinkedHashMap<String,LinkedHashMap<String,String>> fields, boolean initializedFields){
		super(className);
		this.fields=fields;
		fieldsRecord = new LinkedHashMap <String,Type>();
				try { //setto il suo indice
					assignIndex();
				} catch (BEException e) { // non si puo' mai verificare, il tipo e' appena stato creato --> non ha ancora un indice
					e.printStackTrace();
				}
				if(initializedFields)
					setFieldsRecursion(this, fields, DEPTH, true);
				else
					setFieldsRecursion(this, fields, DEPTH, false);
	}

	
	/** Crea un oggetto per la costante null (usato con istruzione aconst_null) */
	public TypeObject(){
		super("NULL");
		this.fields=null;
		fieldsRecord = new LinkedHashMap <String,Type>(); //evita problemi di null pointer (il controllo avviene con isEmpty())
	}
	
	
	//costruttore per gli oggetti corrispondenti alle classi (un oggetto per classe) 
	// non ha alcun indice associato ma ha dei campi che invece sono indicizzabili
	public TypeObject(String className, LinkedHashMap<String,LinkedHashMap<String,String>> fields){
		super(className);
		fieldsRecord = new LinkedHashMap <String,Type>();
		isClassType=true;
		this.fields=fields;
		setFieldsRecursion(this, fields, DEPTH, false);
	}

	// ritorna un indice fresh
	static int getFreshIndex(){
		return indexCounter++;
	}

	//recupera il tipo di un campo
	public Type getFieldType(String fieldName) {
		return fieldsRecord.get(fieldName);
	}
	
	//ritorna l'indice di questo tipo o null se questo tipo non è indicizzato
	public Integer getIndex(){
		return this.index;
	}
	
	//recupera la mappa dei campi di questo oggetto
	private LinkedHashMap <String,Type> getFieldsRecord(){
		return fieldsRecord;
	}
	
	
	/* setta il tipo di un campo di questo oggetto (possibile solo se si assegna lo stesso tipo
	 * o se il campo non era stato inizializzato) */
	public void setFieldType(String fieldName, Type fieldType) throws BEException{
		if(!fieldType.isInt() && this.fieldsRecord.get(fieldName)!=null &&
				!this.fieldsRecord.get(fieldName).equals((TypeObject)fieldType))
			throw new BEException("Non puoi modificare un campo gia' inizializzato");
		else if (fieldType != null && !fieldType.isInt()){
			this.fieldsRecord.put(fieldName, fieldType);
		}
		//altrimenti non devo fare niente (i campi INT sono da subito settati a INT e mai a bottom)
	}

	
	//restituisce l'oggetto con l'indice appena assegnato
	@Override
	public TypeObject assignIndex() throws BEException{
		
		if(this.index!=null) throw new BEException("Non puoi riassegnare un indice ad un tipo");
		else{
			if(!isClassType) // i tipi classe non possono avere un indice associato (ma si possono indicizzare i loro campi)
				this.index=TypeObject.getFreshIndex();
		}
		return this;
	}
	
	
	//ritorna il nome base della classe del tipo senza indici associati
	public String getClassName() {
		return className;
	}
	
	
	// controlla se è un tipo classe
	public boolean isClassType() {
		return isClassType;
	}


	// ritorna il nome del tipo comprensivo di indice (usato per i campi mostrati dentro le parentesi [])
	// il nome del campo a cui e' associato non viene stampato
	public String getIndexName() {
		String s=this.className;
		if(index!=null)
			s+= index;
		return s;
	}
	
	//ritorna il nome del tipo comprensivo di indice e nomi dei tipi genitori
	// (usato quando i campi devono essere mostrati appiattiti per continuare a capire di chi e' il campo)
	public String getFlattenName(){
	
		String s="";
		
		if(fieldName!=null)
			s+=fieldName;
		
		s+= getIndexName();
		
		TypeObject p= parent;
		if(p!=null){
			s=p.getFlattenName()+s;
		}
		
		return s;
	}
	
	
	@Override
	public String getName(){
		String s="";
				
		if(FLATTEN){ //voglio i campi appiattiti per la compatibilita' con il tool DF4ABS
			s= getFlattenName(); //se e' il tipo principale questo mi ritornera' l'indexName del tipo
								//altrimenti mi ritornerà tipiGenitori+nomeCampo+TipoCampo
			return s+=flattenedFields(this, "", ""); //...e di seguito i tipi dei suoi campi separati da ','
			
		}else{ //campi non appiattiti (mostrati tra parentesi quadre)
			s+=getFlattenName(); //se  e' il tipo principale questo mi ritornera' l'indexName del tipo
							//altrimenti mi ritornerà tipiGenitori+nomeCampo+TipoCampo (per ricordare
			return s+=typeAndFields(this); //...e di seguito i suoi campi tra parentesi quadre
		}
	}
	
	
	//controlli per garantire unicita' del tipo all'interno della mappa e per fare comparazioni
	
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
	
	
	/*************************************/
	
	/* costruttore utilizzato solo con funzione setFieldsRecursion*/
	private TypeObject(String className,LinkedHashMap<String,LinkedHashMap<String,String>> fields,
			int depth,boolean initializedFields){
		super(className);
		fieldsRecord = new LinkedHashMap <String,Type>();
		this.fields=fields;
		setFieldsRecursion(this, fields, depth-1,initializedFields);
	}
	
	// setta tutti i tipi dei campi di quest'oggetto ad un tipo fittizio oppure a null (non inizializzati)
	// a seconda del valore initializedFields
	private static void setFieldsRecursion(TypeObject startType, 
			final LinkedHashMap<String,LinkedHashMap<String,String>> fields, int depth, boolean initializedFields){
		
		if (depth==0) return; //termina ricorsione

		if(fields.get(startType.getClassName())!=null){ //abbiamo la classe nella nostra mappa
			//recupero i tipi dei campi
			LinkedHashMap<String,String> f = fields.get(startType.getClassName());
			LinkedHashMap<String,Type> typeFields = new LinkedHashMap <String,Type>();
		    for(Map.Entry<String, String> entry : f.entrySet()){
		    	//entry.getValue() e' il tipo del campo e entry.getKey() e' il suo nome
				if(entry.getValue().equals("INT")) typeFields.put(entry.getKey(),new TypeInt()); //interi considerati sempre inizializzati
				else{ //campo oggetto
					//viene creato un nuovo oggetto con un nuovo indice
					TypeObject t = new TypeObject(entry.getValue(), fields, depth, initializedFields);
					if(initializedFields){ //devo inizializzare i campi
						try {
							t.assignIndex(); //indice fittizio
						} catch (BEException e) {
							e.printStackTrace();
							System.exit(1);
						} 
						t.fieldName=entry.getKey();
						t.parent=startType; //salvo il tipo dell'oggetto che contiene questo campo
					}
					
					typeFields.put(entry.getKey(), t);
				}
			}

			startType.fieldsRecord=typeFields; // tra i campi vi sono salvati anche quelli di tipo INT

		}
		
	}
	
	
	// ritorna la stringa che rappresenta il tipo t comprensivo dei campi visitati ricorsivamente
		private static String typeAndFields(TypeObject t){		
				
				if(t == null) return "⊥";
				
				String s = t.getIndexName();
				if(!t.getFieldsRecord().isEmpty()){
					s+="[";
					for(Map.Entry<String, Type> entry : t.getFieldsRecord().entrySet()){
						String fieldName=entry.getKey(); //nome campo
						if(entry.getValue()!=null && entry.getValue().isInt()) continue; //evito gli INT
						else{	
							s+=fieldName+ " : ";
							s+= typeAndFields(((TypeObject)entry.getValue()))+", " ;	
						}
					}
					if(s.lastIndexOf(",")==s.length()-2)
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
				
				if(t.isClassType) return t.className;
				
				String s = t.getIndexName();
				if(!t.getFieldsRecord().isEmpty()){
					s+=", ";
					for(Map.Entry<String, Type> entry : t.getFieldsRecord().entrySet()){
						String fieldName=entry.getKey(); //nome campo
						if(entry.getValue()!=null && entry.getValue().isInt()) continue; //evito gli INT
						else{
							s+= t.getIndexName()+leftSeparator+fieldName+rightSeparator+flattenedFields(((TypeObject)entry.getValue()),leftSeparator,rightSeparator)+", " ;	
						}
					}
				}
				if(s.lastIndexOf(",")==s.length()-2)
					s= s.substring(0, s.lastIndexOf(",")); //rimuovo l'ultima virgola
				return s;
		}
	
	
	
	
}
