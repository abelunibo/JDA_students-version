package com.laneve.deadlock.models.instructions;

import com.laneve.deadlock.models.Environment;

public interface BEInstruction {
	void handleEnvironment(Environment environment);
}
