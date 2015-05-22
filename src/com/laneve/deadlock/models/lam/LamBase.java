package com.laneve.deadlock.models.lam;

public abstract class LamBase {
	public abstract void semplify(LamBase lam);
	public abstract String getLam();
	public abstract void setLam(String instructionName);
}
