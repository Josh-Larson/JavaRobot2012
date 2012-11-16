package com.dwlarson.joshua.commands.collector;

import com.dwlarson.joshua.Robot;
import com.dwlarson.joshua.commands.CommandBase;

/**
 * Move the ball up until the ball gets out of the lifter.
 * @author Josh Larson
 */
public class MoveBallIntoShooter extends CommandBase {
	
	private boolean ballLoaded = false;
	
	public MoveBallIntoShooter() {
		requires(collector);
	}
	
	public void initialize() {
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
		return (!collector.topTriggered() && ballLoaded) || Robot.disabled;
	}
	
	public void interrupted() {
		
	}
}
