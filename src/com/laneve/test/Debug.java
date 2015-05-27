package com.laneve.test;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import com.laneve.deadlock.type.Type;
import com.laneve.deadlock.type.TypeInt;
import com.laneve.deadlock.type.TypeObject;

public class Debug {
	
	public static void main(String args[]) { 
		
		LinkedHashMap<String,LinkedHashMap<String,Type>> fields;
		
		fields = new LinkedHashMap<String, LinkedHashMap<String, Type>>();
		
		
		/* classe Pippo */
		LinkedHashMap<String, Type> pippoFields= new LinkedHashMap<String, Type>();
		Type t1 = new TypeInt();
		pippoFields.put("C", t1); //campo C di tipo INT della classe Pippo
		Type t2 =  TypeObject.getRawTypeObject ("Pluto");
		pippoFields.put("D", t2); //campo D di tipo Pluto della classe Pippo
		Type t3 =  TypeObject.getRawTypeObject("Micky");
		pippoFields.put("E", t3); //campo E di tipo Micky della classe Pippo
		Type t4 = new TypeInt();
		pippoFields.put("F", t4); //campo F di tipo INT della classe Pippo

		
		
		fields.put("Pippo", pippoFields);
		
		
		/* classe Pluto */
		LinkedHashMap<String, Type> plutoFields= new LinkedHashMap<String, Type>();
		Type t5 = new TypeInt();
		plutoFields.put("o", t5); 
		Type t6 =  TypeObject.getRawTypeObject("Luca");
		plutoFields.put("p", t6); 
		Type t7 =  TypeObject.getRawTypeObject("Mario");
		plutoFields.put("q", t7); 
		Type t8 =  TypeObject.getRawTypeObject("Jack");
		plutoFields.put("r", t8);
		
		fields.put("Pluto", plutoFields);
		
		
		/* classe Topolino */
		LinkedHashMap<String, Type> topolinoFields= new LinkedHashMap<String, Type>();
		Type t9 = TypeObject.getRawTypeObject("Hulk");
		topolinoFields.put("m", t9); 
		Type t10 =  TypeObject.getRawTypeObject("Tessy");
		topolinoFields.put("qwe", t10); 
		Type t11 =  TypeObject.getRawTypeObject("Micky");
		topolinoFields.put("pud", t11);
		Type t12 =  TypeObject.getRawTypeObject("Titti");
		topolinoFields.put("x", t12);
		
		fields.put("Topolino", topolinoFields);
		
		
		/* classe Jack */
		LinkedHashMap<String, Type> jackFields= new LinkedHashMap<String, Type>();
		Type t13 =  TypeObject.getRawTypeObject("Mark");
		jackFields.put("m", t9); 
		Type t14 =  TypeObject.getRawTypeObject("Jain");
		jackFields.put("qwe", t10); 
		Type t15 =  TypeObject.getRawTypeObject("Lucas");
		topolinoFields.put("pud", t11);
		Type t16 =  TypeObject.getRawTypeObject("Patrik");
		jackFields.put("x", t12);
		
		fields.put("Jack", jackFields);
		
		
		/* stampa della mappa fields*/
		
	    for(Map.Entry<String, LinkedHashMap<String, Type>> entry : fields.entrySet()){

	    	System.out.println("-----" + entry.getKey());
	    	
		    for(Map.Entry<String, Type> entry2 : entry.getValue().entrySet()){

		    	if(entry2.getValue().isInt())
		    		System.out.println(entry2.getKey() + " "+ entry2.getValue().getName());
		    	else
		    		System.out.println(entry2.getKey() + " "+ (entry2.getValue()).getName());

		    	
		    }
	    	
	    	System.out.println();
	    	
	    }
	   
	    //nessuna ricorsione sui campi
		Type t20 = new TypeObject("Jack", fields);	
		System.out.println(t20.getName());
		
		//ricorsione sui campi fino profondità 1
		Type t21 = new TypeObject("Pluto", fields);	
		System.out.println(t21.getName());
		
		//ricorsione sui campi fino profondità 2 //funziona se si imposta DEPTH=3 in TypeObject
		Type t22 = new TypeObject("Pippo", fields);	
		System.out.println(t22.getName());

				
	}
	
	/*public static LinkedList<Type> getZbar(LinkedList<Type> z){
		
		
		Set<Type> set = new LinkedHashSet<Type>();
		
		for(int i=0; i < z.size(); i++){
			set.add(z.get(i));
		}
		
		return z!=null && z.size()>0?new LinkedList<Type>(set):null;
		
	}
	
	
	public static String getTopZbar(LinkedList<Type> z){
		
		LinkedList<Type> zbar= getZbar(z);
		return zbar!=null && zbar.size()>0?zbar.get(zbar.size()-1).getName():null;		
	}
	
	
	public static String getZhat(LinkedList<Type> z){
		
		String zHat = "";
				
		if(z!=null && z.size()>1){
			
			zHat+= "(" + z.get(0).getName() + "," + z.get(1).getName() + ")";
						
			for(int i=1; i < z.size() -  1; i++){
								
				zHat+= " & (" + z.get(i).getName() + "," + z.get(i+1).getName() + ")";
			
			}
			
		}
		
		return zHat.isEmpty()?"0":zHat;
		
	}
	
	
	public static String getZhatBar(LinkedList<Type> z){
		
		return z!=null && z.size()>0?getZhat(getZbar(z)):null;
	}
	
	
	public static String getThat(LinkedList<Type> t){
	

		String tHat = "";
				
		if(t!=null && t.size()>1){
		
			tHat+= "run("+t.get(0).getName()+")";
			
			for(int i=1; i < t.size(); i++){

					tHat+= " & run("+t.get(i).getName()+")";
			}
					
		}
		
		return tHat.isEmpty()?"0":tHat;

	}*/
	
}
