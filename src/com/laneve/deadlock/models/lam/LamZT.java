package com.laneve.deadlock.models.lam;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import com.laneve.deadlock.models.Environment;

public class LamZT extends LamBase{
	String lam;
	LinkedList<String> z = new LinkedList<String>();
	LinkedList<String> t = new LinkedList<String>();
	
	public String getLam() {
		return lam;
	}

	public void setLam(String lam) {
		this.lam = lam;
	}
	
	public static LinkedList<String> getZbar(LinkedList<String> z){
		Set<String> set = new HashSet<String>();
		for(int i=0; i < z.size(); i++){
			set.add(z.get(i));
		}
		return z!=null && z.size()>0?new LinkedList<String>(set):null;
	}
	
	
	public static String getTopZbar(LinkedList<String> z){
		LinkedList<String> zbar= getZbar(z);
		return zbar!=null && zbar.size()>0?zbar.get(zbar.size()-1):null;		
	}
	
	public static String getZhat(LinkedList<String> z){
		String zHat = "";
		if(z!=null && z.size()>1){
			zHat+= "(" + z.get(0) + "," + z.get(1) + ")";
			for(int i=1; i < z.size() -  1; i++){
				zHat+= " & (" + z.get(i) + "," + z.get(i+1) + ")";
			}
		}
		return zHat.isEmpty()?"0":zHat;
	}
	
	
	public static String getZhatBar(LinkedList<String> z){
		return z!=null && z.size()>0?getZhat(getZbar(z)):null;
	}
	
	
	/* Calcola T cappello */
	public static String getThat(LinkedList<String> t){
		String tHat = "";
		if(t!=null && t.size()>1){
			tHat+= "run("+t.get(0)+")";
			for(int i=1; i < t.size(); i++){
					tHat+= " & run("+t.get(i)+")";
			}
		}
		return tHat.isEmpty()?"0":tHat;
	}
	
	@Override
	public void semplify(LamBase lam) {
	
	}
	
	public static void addDebugZT(Environment environment){
		LinkedList<String> z = new LinkedList<String>();
		z.add("a");
		z.add("b");
		z.add("c");
		z.add("b"); 
		z.add("d");
		z.add("c");
		z.add("c");
		z.add("a");
		z.add("e");
		z.add("c"); 
	
		LinkedList<String> t = new LinkedList<String>();
		t.add("p");
		t.add("q");
		t.add("r");
		environment.setLocks(z);
		environment.setQueuethreads(t);
	}
	
}
