package com.dwlarson.joshua.commands.drive_train;

import com.dwlarson.joshua.commands.CommandBase;

/**
 * Toggles between tank drive and arcade drive on the drive
 * train.
 * @author Josh Larson
 */
public class ToggleTankArcade extends CommandBase {
	
	protected void initialize() {
		oi.setArcadeDrive(!oi.isArcadeDrive());
	}
	
	protected void execute() {
		
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		
	}
	
}
