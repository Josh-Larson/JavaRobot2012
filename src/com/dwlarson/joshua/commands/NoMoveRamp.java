package com.dwlarson.joshua.commands;

/**
 * Stops the ramp manipulator from moving.
 * @author Josh Larson
 */
public class NoMoveRamp extends CommandBase {
	
	public NoMoveRamp() {
		requires(rampManipulator);
	}
	
	protected void initialize() {
		
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
