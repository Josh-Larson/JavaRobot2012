package com.dwlarson.joshua.commands.collector;

import com.dwlarson.joshua.commands.CommandBase;

/**
 * Pushes the ball out if it is on the grabber. Continues
 * until cancelled.
 * @author Josh Larson
 */
public class MoveBallOut extends CommandBase {
	
	public MoveBallOut() {
		requires(collector);
	}
	
	public void initialize() {
		
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
