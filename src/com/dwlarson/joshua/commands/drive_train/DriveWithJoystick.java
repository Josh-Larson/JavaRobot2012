package com.dwlarson.joshua.commands.drive_train;

import com.dwlarson.joshua.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;

/**
 * The command used to drive with the joystick in operator
 * control mode. This will use the drive trian to move it
 * as long as it can.
 * @author Josh Larson
 */
public class DriveWithJoystick extends CommandBase {
	
	private Timer timer;
	
	public DriveWithJoystick() {
		requires(driveTrain);
		timer = new Timer();
		timer.reset();
		timer.start();
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		if (timer.get() >= 0.05) {
			driveTrain.driveWithJoystick(oi.isArcadeDrive(), oi.getJoystick1(), oi.getJoystick2());
			timer.reset();
		}
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		
	}
	
}
