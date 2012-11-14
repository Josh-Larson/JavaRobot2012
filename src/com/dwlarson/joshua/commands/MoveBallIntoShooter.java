package com.dwlarson.joshua.commands;

/**
 * Move the ball up until the ball gets out of the lifter.
 * @author Josh Larson
 */
public class MoveBallIntoShooter extends CommandBase {
	
	private boolean ballLoaded = false;
	
	public void initialize() {
		requires(collector);
		setTimeout(4.0);
	}
	
	public void execute() {
		collector.moveUp();
		if (collector.topTriggered()) {
			ballLoaded = true;
		}
	}
	
	public void end() {
		
	}
	
	public boolean isFinished() {
		return !collector.topTriggered() && ballLoaded;
	}
	
	public void interrupted() {
		
	}
}
