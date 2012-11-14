package com.dwlarson.joshua.commands;

/**
 * Stops the ramp manipulator from moving.
 * @author Josh Larson
 */
public class NoMoveRamp extends CommandBase {
	
	protected void initialize() {
		requires(rampManipulator);
	}
	
	protected void execute() {
		rampManipulator.noMoveRamp();
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		
	}
	
}
