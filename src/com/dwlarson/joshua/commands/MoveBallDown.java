package com.dwlarson.joshua.commands;

/**
 * Moves the ball down in the collector. This is controlled
 * in the lifter, as opposed to the grabber.
 * @author Josh Larson
 */
public class MoveBallDown extends CommandBase {
	
	
	public void initialize() {
		requires(collector);
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
