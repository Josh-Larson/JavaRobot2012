package com.dwlarson.joshua.commands.shooter;

import com.dwlarson.joshua.commands.collector.MoveBallIntoShooter;
import com.dwlarson.joshua.commands.collector.PrepareBallToShoot;
import com.dwlarson.joshua.commands.shooter.GetShooterUpToSpeed;

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
		addSequential(new OutputShooterData());
		addSequential(new GetShooterUpToSpeed());
		addSequential(new MoveBallIntoShooter());
	}
}
