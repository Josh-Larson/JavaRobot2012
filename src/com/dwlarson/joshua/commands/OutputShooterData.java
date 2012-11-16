package com.dwlarson.joshua.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Josh Larson
 */
public class OutputShooterData extends CommandBase {
	
	public OutputShooterData() {
		requires(shooter);
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		SmartDashboard.putDouble("Top Shooter", shooter.getTopRate());
		SmartDashboard.putDouble("Bottom Shooter", shooter.getBottomRate());
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			
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
