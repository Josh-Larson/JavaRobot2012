package com.dwlarson.joshua.commands;

/**
 * Move the ramp manipulator down until cancelled.
 * @author Josh Larson
 */
public class MoveRampDown extends CommandBase {
	
	public MoveRampDown() {
		requires(rampManipulator);
	}
	
	protected void initialize() {
		rampManipulator.moveRampDown();
	}
	
	protected void execute() {
		
	}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		
	}
	
}
