package com.laneve.deadlock.models.lam;

public  class LamBase {
	static String lam;
	
   void semplify(LamBase lam){
	   
   };

	public String getLam() {
		return lam;
	}
	public void setLam(String lam) {
		LamBase.lam += lam+" ; ";
	}
}
