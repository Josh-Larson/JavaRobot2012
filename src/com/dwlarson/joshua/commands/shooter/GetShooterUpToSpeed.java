package com.dwlarson.joshua.commands.shooter;

import com.dwlarson.joshua.Robot;
import com.dwlarson.joshua.RobotMap;
import com.dwlarson.joshua.commands.CommandBase;

/**
 * Uses the shooter to get the two jaguars up to speed. It
 * will end if the timeout occurs or it gets successfully
 * up to speed.
 * @author Josh Larson
 */
public class GetShooterUpToSpeed extends CommandBase {
	
	public GetShooterUpToSpeed() {
		requires(shooter);
	}
	
	public void initialize() {
		setTimeout(7.0);
		shooter.fireUpPID(RobotMap.SHOOTER_SPEED_CONSTANT, 1);
	}
	
	public void execute() {
		
	}
	
	public void end() {
		shooter.disable();
	}
	
	public boolean isFinished() {
		return shooter.isSpeedClose() || Robot.disabled;
	}
	
	public void interrupted() {
		
	}
}
