
package com.dwlarson.joshua.subsystems;

import com.dwlarson.joshua.RobotMap;
import com.dwlarson.joshua.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *  The drive train for the robot. This will
 *  make the robot move with the joystick supplied.
 */
public class DriveTrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private Jaguar leftJaguar;
	private Jaguar rightJaguar;
	private Encoder leftEncoder;
	private Encoder rightEncoder;
	
	
	public void initDefaultCommand() {
		setDefaultCommand(new DriveWithJoystick());
	}
	
	public DriveTrain() {
		leftJaguar   = new Jaguar(1, RobotMap.DRIVETRAIN_JAGUAR_LEFT);
		rightJaguar  = new Jaguar(1, RobotMap.DRIVETRAIN_JAGUAR_RIGHT);
		leftEncoder  = new Encoder(RobotMap.DRIVETRAIN_ENCODER_LEFT_A, RobotMap.DRIVETRAIN_ENCODER_LEFT_B);
		rightEncoder = new Encoder(RobotMap.DRIVETRAIN_ENCODER_RIGHT_A, RobotMap.DRIVETRAIN_ENCODER_RIGHT_B);
		leftJaguar.setSafetyEnabled(false);
		rightJaguar.setSafetyEnabled(false);
	}
	
	public void driveWithJoystick(boolean arcade, Joystick j1, Joystick j2) {
		if (arcade) {
			if (j1 == null) return;
			double rot = j1.getAxis(Joystick.AxisType.kX);
			double y = j1.getAxis(Joystick.AxisType.kY);
			SmartDashboard.putDouble("X", rot);
			SmartDashboard.putDouble("Y", y);
			arcadeDrive(rot, y * y * y);
		} else {
			if (j1 == null || j2 == null) return;
			double y1 = j1.getAxis(Joystick.AxisType.kY);
			double y2 = j2.getAxis(Joystick.AxisType.kY);
			tankDrive(y1, y2);
		}
	}
	
	private void arcadeDrive(double rot, double speed) {
		leftJaguar.set(rot - speed);
		rightJaguar.set(-1 * rot - speed);
		SmartDashboard.putDouble("LeftJaguar", leftJaguar.get());
		SmartDashboard.putDouble("RightJaguar", rightJaguar.get());
	}
	
	private void tankDrive(double y1, double y2) {
		leftJaguar.set(y1);
		rightJaguar.set(y2);
	}
}

