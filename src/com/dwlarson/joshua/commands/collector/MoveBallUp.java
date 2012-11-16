package com.dwlarson.joshua.commands.collector;

import com.dwlarson.joshua.commands.CommandBase;

/**
 * Moves the ball up the lifter until cancelled.
 * @author Josh Larson
 */
public class MoveBallUp extends CommandBase {
	
	public MoveBallUp() {
		requires(collector);
	}
	
	public void initialize() {
		
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
