package com.laneve.deadlock.models.lam;

import java.util.ArrayList;

public class LamSequence extends LamBase {
	public String lam="";
	
	private ArrayList<String> lArr;
	
	public LamSequence(){
		
		lArr = new ArrayList<String>();
	}
	
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
		
		String genLam = generateLam.getLam();
				
		if(lArr.size()>0 && lArr.contains(genLam)){ 
			
			//non aggiungere niente se lam gia' presente 
			
		} else if((!(genLam.trim().equals("0") || genLam.trim().equals("") || genLam.trim().equals("0 & 0")))){
			lam += genLam+" ; ";
			lArr.add(genLam);
		}
			
	}

}
