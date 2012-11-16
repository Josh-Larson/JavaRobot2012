package com.dwlarson.joshua.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * 
 * @author Josh Larson
 */
public class CollectorRunning extends CommandGroup {
	public CollectorRunning() {
		addSequential(new MoveBallThroughCollector());
		addSequential(new OutputCollectorData());
	}
}
