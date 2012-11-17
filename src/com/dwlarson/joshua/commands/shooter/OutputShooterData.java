package com.dwlarson.joshua.commands.shooter;

import com.dwlarson.joshua.Robot;
import com.dwlarson.joshua.commands.CommandBase;

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
		Robot.splitCPU++;
	}
	
	protected void execute() {
		long startTime = System.currentTimeMillis();
		SmartDashboard.putDouble("Top Shooter", shooter.getTopRate());
		SmartDashboard.putDouble("Bottom Shooter", shooter.getBottomRate());
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
