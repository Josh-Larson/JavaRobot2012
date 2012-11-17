package com.dwlarson.joshua.commands.shooter;

import com.dwlarson.joshua.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Josh Larson
 */
public class OutputShooterData extends CommandBase {
	
	private Timer timer;
	
	public OutputShooterData() {
		requires(shooter);
		timer = new Timer();
		timer.reset();
		timer.start();
	}
	
	protected void initialize() {
		SmartDashboard.putString("Debug", "1");
	}
	
	protected void execute() {
		if (timer.get() >= 0.1) {
			SmartDashboard.putDouble("Top Shooter", shooter.getTopRate());
			SmartDashboard.putDouble("Bottom Shooter", shooter.getBottomRate());
			//SmartDashboard.putString("Debug", "2");
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
