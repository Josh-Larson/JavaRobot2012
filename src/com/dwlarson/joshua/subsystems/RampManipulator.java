package com.dwlarson.joshua.subsystems;

import com.dwlarson.joshua.RobotMap;
import com.dwlarson.joshua.commands.ramp_manipulator.NoMoveRamp;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This class controls the ramp manipulator.
 * @author Josh Larson
 */
public class RampManipulator extends Subsystem {

	private Victor victor;
	private Relay relay;

	public void initDefaultCommand() {
		setDefaultCommand(new NoMoveRamp());
	}

	public RampManipulator() {
		victor = new Victor(RobotMap.RAMPMANIPULATOR_VICTOR);
		relay = new Relay(RobotMap.RAMPMANIPULATOR_RELAY);
	}

	public void disable() {
		victor.set(0);
		relay.set(Relay.Value.kOff);
	}

	public void moveRampUp() {
		victor.set(-0.3);
		//relay.set(Relay.Value.kOn);
	}

	public void moveRampDown() {
		victor.set(0.3);
		//relay.set(Relay.Value.kReverse);
	}

	public void noMoveRamp() {
		victor.set(0);
		//relay.set(Relay.Value.kOff);
	}
}
