package com.laneve.deadlock.models.lam;

public class LamSequence extends LamBase {
	public String lam;
	
	public String getLam() {
		return lam;
	}
	
	public void setLam(String lam) {
		this.lam = lam;
	}
	
	@Override
	public void semplify(LamBase lam) {
		
	}

	public void createSequence(LamBase generateLam) {
		lam += generateLam.getLam()+" ; ";
		
	}

}
