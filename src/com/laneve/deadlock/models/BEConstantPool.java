package com.laneve.deadlock.models;


public class BEConstantPool extends BEBase{
	BETableEntries tableEntries;

	public BEConstantPool(BETableEntries tableEntries) {
		this.tableEntries = tableEntries;
	}

	public BETableEntries getTableEntries() {
		return tableEntries;
	}

}
