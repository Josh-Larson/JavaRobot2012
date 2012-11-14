package com.dwlarson.joshua.commands;

/**
 * Moves the ball in via the collector. This is on the 
 * grabber, rather than the lifter. Continues until cancelled.
 * @author Josh Larson
 */
public class MoveBallIn extends CommandBase {
	
	protected void initialize() {
		requires(collector);
	}
	
	protected void execute() {
		collector.moveIn();
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		
	}
	
}
