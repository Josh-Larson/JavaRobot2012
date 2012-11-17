package com.dwlarson.joshua.commands.ramp_manipulator;

import com.dwlarson.joshua.Robot;
import com.dwlarson.joshua.commands.CommandBase;

/**
 * Stops the ramp manipulator from moving.
 * @author Josh Larson
 */
public class NoMoveRamp extends CommandBase {
	
	public NoMoveRamp() {
		requires(rampManipulator);
	}
	
	protected void initialize() {
		Robot.splitCPU++;
	}
	
	protected void execute() {
		long startTime = System.currentTimeMillis();
		rampManipulator.noMoveRamp();
		try { Thread.sleep(Robot.sleepTime(System.currentTimeMillis() - startTime)); } catch (InterruptedException e) { }
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		Robot.splitCPU--;
	}
	
	protected void interrupted() {
		
	}
	
}
