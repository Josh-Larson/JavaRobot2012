package com.dwlarson.joshua.commands.shooter;

import com.dwlarson.joshua.commands.CommandBase;

public class TurnTurret extends CommandBase {
	
	public TurnTurret() {
		requires(shooter);
		setTimeout(0.05);
	}
	
	protected void initialize() {
		shooter.turnWithJoystick(oi.getJoystick1());
	}
	
	protected void execute() {
		
	}
	
	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		shooter.stopTurret();
	}

	protected void interrupted() {
		
	}
	
}
