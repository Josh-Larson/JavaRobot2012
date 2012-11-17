package com.dwlarson.joshua.commands.collector;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * 
 * @author Josh Larson
 */
public class CollectorRunning extends CommandGroup {
	public CollectorRunning() {
		addSequential(new MoveBallIntoCollector());
		addSequential(new OutputCollectorData());
	}
}
