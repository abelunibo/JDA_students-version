package com.laneve.deadlock.models.lam;

import java.util.ArrayList;
import java.util.Iterator;


public class LamAnd extends LamSubExpr{
	
	ArrayList<LamSubExpr> lamAnd=new ArrayList<LamSubExpr>();
	
	public LamAnd(LamSubExpr...lamsub){

		    for (LamSubExpr l : lamsub) { //TODO si possono rifiutare le LamZero da subito
		    	if(l!=null)
		        	lamAnd.add(l);
		    }
	}
	
	public LamAnd(ArrayList<LamSubExpr> lamsub){
	    for (LamSubExpr l : lamsub) { //TODO si possono rifiutare le LamZero da subito
	    	if(l!=null)
	        	lamAnd.add(l);
	    }
	}
	
	@Override
	public String simplify(){ //rimuovo temporaneamente le lam zero e restituisco la stringa aggiornata
				
		ArrayList<LamSubExpr> backup=new ArrayList<LamSubExpr>(lamAnd);	
		ArrayList<LamSubExpr> tmp=new ArrayList<LamSubExpr>();	
		
		for(int i=0; i<lamAnd.size();i++){
			LamSubExpr lsub = lamAnd.get(i);
			/*if(lsub instanceof LamCouple) 
				System.out.println("Debug");*/
			String simplified = lsub.simplify();
			if(!simplified.equals("0"))
				tmp.add(lsub);
		}
		
		lamAnd=tmp;
		
		String s = toString();
		
		lamAnd=backup;
		
		return s;
	}

	@Override
	public String toString() {
		
		String s="";
		if(lamAnd.size() > 0){
			for (LamSubExpr l : lamAnd) {
		        s+=l.toString() + " & ";
		    }
			if(s.lastIndexOf("&")==s.length()-2)
				s=s.substring(0, s.lastIndexOf("&")-1);
		}else s="0";

		return s;
	}

}
