package com.dwlarson.joshua.commands;

/**
 * Move the ramp manipulator down until cancelled.
 * @author Josh Larson
 */
public class MoveRampDown extends CommandBase {
	
	
	protected void initialize() {
		requires(rampManipulator);
	}
	
	protected void execute() {
		rampManipulator.moveRampDown();
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		rampManipulator.noMoveRamp();
	}
	
	protected void interrupted() {
		
	}
	
}
