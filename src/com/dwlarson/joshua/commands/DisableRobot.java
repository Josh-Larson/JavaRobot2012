package com.dwlarson.joshua.commands;

import com.dwlarson.joshua.Robot;

/**
 * Disables all motors and commands that is currently running
 * to stop if from moving after re-enabling.
 * @author Josh Larson
 */
public class DisableRobot extends CommandBase {
	
	public DisableRobot() {
		requires(shooter);
		requires(collector);
		requires(driveTrain);
		requires(rampManipulator);
	}
	
	public void initialize() {
		shooter.disable();
		collector.disable();
		driveTrain.disable();
		rampManipulator.disable();
	}

	protected void execute() {
		shooter.disable();
		collector.disable();
		driveTrain.disable();
		rampManipulator.disable();
		try { Thread.sleep(1); } catch (InterruptedException e) { }
	}

	protected boolean isFinished() {
		return !Robot.disabled;
	}

	protected void end() {
		
	}

	protected void interrupted() {
		
	}
	
	
}
