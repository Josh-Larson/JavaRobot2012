package com.dwlarson.joshua.commands.collector;

import com.dwlarson.joshua.commands.CommandBase;

/**
 * Moves the ball down in the collector. This is controlled
 * in the lifter, as opposed to the grabber.
 * @author Josh Larson
 */
public class MoveBallDown extends CommandBase {
	
	public MoveBallDown() {
		requires(collector);
	}
	
	public void initialize() {
		
	}
	
	public void execute() {
		collector.moveDown();
	}
	
	public void end() {
		
	}
	
	public boolean isFinished() {
		return false;
	}
	
	public void interrupted() {
		
	}
}
