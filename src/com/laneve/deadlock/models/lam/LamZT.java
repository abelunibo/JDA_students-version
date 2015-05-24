package com.laneve.deadlock.models.lam;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

import com.laneve.deadlock.type.Type;

public class LamZT extends LamBase{
	String lam;
	
	public String getLam() {
		return lam;
	}

	public void setLam(String lam) {
		this.lam = lam;
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
	
	@Override
	public void semplify(LamBase lam) {
	
	}
	
}
