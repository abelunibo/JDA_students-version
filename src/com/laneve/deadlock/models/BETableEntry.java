package com.laneve.deadlock.models;


public class BETableEntry extends BEBase{
	BERef ref;
	BEConstantAndInfo costantAndInfo;
	
	public BETableEntry(BERef ref, BEConstantAndInfo costantAndInfo) {
		this.ref = ref;
		this.costantAndInfo = costantAndInfo;
	}

	public BERef getRef() {
		return ref;
	}

	public BEConstantAndInfo getCostantAndInfo() {
		return costantAndInfo;
	}
	
}
