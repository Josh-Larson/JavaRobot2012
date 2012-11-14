package com.dwlarson.joshua.commands;

/**
 * Prepares the next ball for shooting by moving a ball up
 * until it is detected at the top.
 * @author Josh Larson
 */
public class PrepareBallToShoot extends CommandBase {
	
	public void initialize() {
		requires(collector);
		setTimeout(4.0);
	}
	
	public void execute() {
		collector.moveUp();
	}
	
	public void end() {
		
	}
	
	public boolean isFinished() {
		return collector.topTriggered();
	}
	
	public void interrupted() {
		
	}
}