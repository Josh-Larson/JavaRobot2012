package com.dwlarson.joshua.commands;

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
		
	}
	
	protected void execute() {
		driveTrain.driveWithJoystick(oi.isArcadeDrive(), oi.getJoystick1(), oi.getJoystick2());
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		
	}
	
}
