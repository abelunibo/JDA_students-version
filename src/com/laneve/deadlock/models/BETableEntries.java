package com.laneve.deadlock.models;

import java.util.HashMap;

import com.laneve.deadlock.models.lam.LamBase;


public class BETableEntries extends BEBase{
	HashMap<String, BEConstantAndInfo> tableEntry =  new HashMap<String, BEConstantAndInfo>();

	public void addTableEntry(BETableEntry tableEntry) {
		this.tableEntry.put(tableEntry.getRef(), tableEntry.costantAndInfo);
	}

	public HashMap<String, BEConstantAndInfo> getTableEntry() {
		return tableEntry;
	}

	@Override
	public LamBase generateLam(Environment environment) {
		// TODO Auto-generated method stub
		return null;
	}
}
