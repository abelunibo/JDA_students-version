package com.laneve.test;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

import com.laneve.deadlock.type.Type;
import com.laneve.deadlock.type.TypeObject;

public class LamFunctions {
	
	public static void main(String args[]) { 
	
		LinkedList<Type> z = new LinkedList<Type>();
		z.add(new TypeObject("a"));
		z.add(new TypeObject("b"));
		z.add(new TypeObject("c"));
		z.add(new TypeObject("b")); 
		z.add(new TypeObject("d"));
		z.add(new TypeObject("c"));
		z.add(new TypeObject("c"));
		z.add(new TypeObject("a"));
		z.add(new TypeObject("e"));
		z.add(new TypeObject("c")); //l'ultimo lock preso e' in fondo alla lista
	
		LinkedList<Type> t = new LinkedList<Type>();
		t.add(new TypeObject("p"));
		t.add(new TypeObject("q"));
		t.add(new TypeObject("r"));
		
		System.out.print("Z --> [ ");
		
		for(int i=0; i<z.size();i++){
			
			System.out.print(z.get(i).getName()+ " ");
			
		}
		
		System.out.println("]");
		
		LinkedList<Type> zbar = getZbar(z);
		
		System.out.print("Z{segnato} --> [ ");
		
		for(int i=0; i<zbar.size();i++){
			
			System.out.print(zbar.get(i).getName()+ " ");
			
		}
		
		System.out.println("]");

				
		System.out.println("TopZ{segnato} --> " + getTopZbar(z));
		
		//System.out.println("ZHat --> " + getZhat(z));

		System.out.println("ZHat{segnato} --> " + getZhatBar(z));
		
		System.out.println("THat --> " + getThat(t));

	}
	
	public static LinkedList<Type> getZbar(LinkedList<Type> z){
		
		
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
	
	
	/* Calcola T cappello */
	public static String getThat(LinkedList<Type> t){
	

		String tHat = "";
				
		if(t!=null && t.size()>1){
		
			tHat+= "run("+t.get(0).getName()+")";
			
			for(int i=1; i < t.size(); i++){

					tHat+= " & run("+t.get(i).getName()+")";
			}
					
		}
		
		return tHat.isEmpty()?"0":tHat;

	}
	
}
