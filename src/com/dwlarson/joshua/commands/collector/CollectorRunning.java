package com.dwlarson.joshua.commands.collector;

import java.util.Date;

import com.dwlarson.joshua.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * 
 * @author Josh Larson
 */
public class CollectorRunning extends CommandGroup {
	public CollectorRunning() {
		long startTime = new Date().getTime();
		addSequential(new MoveBallIntoCollector());
		addSequential(new OutputCollectorData());
		try { Thread.sleep(Robot.sleepTime(new Date().getTime() - startTime)); } catch (InterruptedException e) { }
	}
}
