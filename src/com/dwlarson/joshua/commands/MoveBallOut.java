package com.dwlarson.joshua.commands;

/**
 * Pushes the ball out if it is on the grabber. Continues
 * until cancelled.
 * @author Josh Larson
 */
public class MoveBallOut extends CommandBase {
	
	
	public void initialize() {
		requires(collector);
	}
	
	public void execute() {
		collector.moveOut();
	}
	
	public void end() {
		
	}
	
	public boolean isFinished() {
		return false;
	}
	
	public void interrupted() {
		
	}
}
