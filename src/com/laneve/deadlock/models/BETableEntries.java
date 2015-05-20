package com.laneve.deadlock.models;

import java.util.HashMap;


public class BETableEntries extends BEBase{
	HashMap<BERef, BEConstantAndInfo> tableEntries =  new HashMap<BERef, BEConstantAndInfo>();

	public void addTableEntry(BETableEntry tableEntry) {
		this.tableEntries.put(tableEntry.getRef(), tableEntry.costantAndInfo);
	}

	public HashMap<BERef, BEConstantAndInfo> getTableEntries() {
		return tableEntries;
	}
}
