package com.dwlarson.joshua.commands.ramp_manipulator;

import com.dwlarson.joshua.commands.CommandBase;

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
