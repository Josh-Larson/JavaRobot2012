package com.dwlarson.joshua.commands;

/**
 * Moves the ball up the lifter until cancelled.
 * @author Josh Larson
 */
public class MoveBallUp extends CommandBase {
	
	
	public void initialize() {
		requires(collector);
	}
	
	public void execute() {
		collector.moveUp();
	}
	
	public void end() {
		
	}
	
	public boolean isFinished() {
		return false;
	}
	
	public void interrupted() {
		
	}
}
