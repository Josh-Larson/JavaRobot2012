package com.dwlarson.joshua.commands;

import com.dwlarson.joshua.RobotMap;

/**
 * Uses the shooter to get the two jaguars up to speed. It
 * will end if the timeout occurs or it gets successfully
 * up to speed.
 * @author Josh Larson
 */
public class GetShooterUpToSpeed extends CommandBase {
	
	public void initialize() {
		requires(shooter);
		setTimeout(7.0);
	}
	
	public void execute() {
		shooter.fireUpPID(RobotMap.SHOOTER_SPEED_CONSTANT, 1);
	}
	
	public void end() {
		
	}
	
	public boolean isFinished() {
		return shooter.isSpeedClose();
	}
	
	public void interrupted() {
		
	}
}
