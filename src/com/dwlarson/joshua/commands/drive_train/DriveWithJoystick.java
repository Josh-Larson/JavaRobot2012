package com.dwlarson.joshua.commands.drive_train;

import com.dwlarson.joshua.Robot;
import com.dwlarson.joshua.commands.CommandBase;

/**
 * The command used to drive with the joystick in operator
 * control mode. This will use the drive trian to move it
 * as long as it can.
 * @author Josh Larson
 */
public class DriveWithJoystick extends CommandBase {
	
	public DriveWithJoystick() {
		requires(driveTrain);
	}
	
	protected void initialize() {
		Robot.splitCPU++;
	}
	
	protected void execute() {
		long startTime = System.currentTimeMillis();
		driveTrain.driveWithJoystick(oi.isArcadeDrive(), oi.getJoystick1(), oi.getJoystick2());
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
