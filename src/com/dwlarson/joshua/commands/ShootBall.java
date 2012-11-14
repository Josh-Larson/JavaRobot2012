package com.dwlarson.joshua.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Command group to shoot a ball into the target. The
 * commands consist of PrepareBallToShoot, 
 * GetShooterUpToSpeed, and MoveBallIntoShooter. These all
 * work together to shoot.
 * @author Josh Larson
 */
public class ShootBall extends CommandGroup {
	
	public ShootBall() {
		addParallel(new PrepareBallToShoot());
		addSequential(new GetShooterUpToSpeed());
		addSequential(new MoveBallIntoShooter());
	}
}
