package com.laneve.deadlock.models;

import com.laneve.deadlock.models.lam.LamBase;


public class BEConstantPool extends BEBase{
	BETableEntries tableEntries;

	public BEConstantPool(BETableEntries tableEntries) {
		this.tableEntries = tableEntries;
	}

	public BETableEntries getTableEntries() {
		return tableEntries;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		// TODO Auto-generated method stub
		return null;
	}

}
