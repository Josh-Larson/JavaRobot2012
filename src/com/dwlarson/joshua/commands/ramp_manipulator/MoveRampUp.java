package com.dwlarson.joshua.commands.ramp_manipulator;

import com.dwlarson.joshua.commands.CommandBase;

/**
 * Moves the ramp manipulator up until cancelled.
 * @author Josh Larson
 */
public class MoveRampUp extends CommandBase {
	
	public MoveRampUp() {
		requires(rampManipulator);
	}
	
	protected void initialize() {
		rampManipulator.moveRampUp();
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
