/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.dwlarson.joshua;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import com.dwlarson.joshua.commands.CommandBase;
import com.dwlarson.joshua.commands.AutonomousCommands;
import com.dwlarson.joshua.commands.OperatorCommands;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	private Command autonomousCommands;
	private Command teleopCommands;
	public static boolean disabled = true;
	public static double goalCpuUsage = 100.0;
	public static int splitCPU = 0;
	
	public static long sleepTime(long usedTime) {
		if (splitCPU == 0) return (long) (goalCpuUsage);
		long sleep = (long) (goalCpuUsage / splitCPU / 5);
		if (sleep < 0) sleep = 0;
		return sleep;
	}
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		// Create the two commands that are for OperatorControl and Autonomous
		autonomousCommands = new AutonomousCommands();
		teleopCommands     = new OperatorCommands();
		
		// Initialize all subsystems
		CommandBase.init();
	}
	
	/**
	 * This function is called when the autonomous period begins
	 */
	public void autonomousInit() {
		teleopCommands.cancel();
		autonomousCommands.start();
		Robot.disabled = false;
	}
	
	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
	
	/**
	 * This function is called when the tele operated period begins
	 */
	public void teleopInit() {
		autonomousCommands.cancel();
		teleopCommands.start();
		System.out.println("Initialized Teleop");
		Robot.disabled = false;
	}
	
	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	
	/**
	 * Called when the robot is disabled
	 */
	public void disabledInit() {
		Robot.disabled = true;
	}
}
