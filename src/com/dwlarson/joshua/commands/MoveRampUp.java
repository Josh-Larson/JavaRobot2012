package com.dwlarson.joshua.commands;

/**
 * Moves the ramp manipulator up until cancelled.
 * @author Josh Larson
 */
public class MoveRampUp extends CommandBase {
	
	
	protected void initialize() {
		requires(rampManipulator);
	}
	
	protected void execute() {
		rampManipulator.moveRampUp();
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
