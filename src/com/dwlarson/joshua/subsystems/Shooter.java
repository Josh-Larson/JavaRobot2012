package com.dwlarson.joshua.subsystems;

import com.dwlarson.joshua.RobotMap;
import com.dwlarson.joshua.SingleChannelEncoder;
import com.dwlarson.joshua.commands.OutputShooterData;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The shooter Subsystem. This subsystem controls the two
 * jaguars mounted on the turret, along with the turret
 * rotation victor. This does the calculations for the ball
 * to go into the hoop. 
 * @author Josh Larson
 *
 */
public class Shooter extends Subsystem {

    private Jaguar top;
    private Jaguar bottom;
    private SingleChannelEncoder topEncoder;
    private SingleChannelEncoder bottomEncoder;
    private PIDController topPID;
    private PIDController bottomPID;
    private double ratio;

    public void initDefaultCommand() {
		setDefaultCommand(new OutputShooterData());
    }
	
    public Shooter() {
		top = new Jaguar(RobotMap.SHOOTER_JAGUAR_TOP);
		bottom = new Jaguar(RobotMap.SHOOTER_JAGUAR_BOTTOM);
		topEncoder = new SingleChannelEncoder(
			RobotMap.SHOOTER_ENCODER_TOP_A,
			RobotMap.SHOOTER_ENCODER_PULSES_SEC,
			top);
		bottomEncoder = new SingleChannelEncoder(
			RobotMap.SHOOTER_ENCODER_BOTTOM_A,
			RobotMap.SHOOTER_ENCODER_PULSES_SEC,
			bottom);
		topPID = new PIDController(.12, .013, 0.0, topEncoder, top);
		bottomPID = new PIDController(.12, .026, 0.0, bottomEncoder, bottom);
		topPID.setSetpoint(0);
		bottomPID.setSetpoint(0);
		ratio = 1;
    }
	
	public void disable() {
		topPID.disable();
		bottomPID.disable();
		top.set(0);
		bottom.set(0);
	}
	
    public void setRatio(double distance) {
		if (distance < 1.0 || distance > 60.0) {
			distance = 16.0;
		}
		double spin = getSpinForDistance(distance);
		if (spin == Double.NaN) {
			spin = getSpinForDistance(16);
		}
		if (spin > 1) {
			spin = 1;
		}
		ratio = spin;
    }

    private double getSpinForDistance(double distance) {
		return 1.827142857e-2 * distance - 0.19;
    }

    public void fireUpPID(double speed, int shots) {
		topPID.setSetpoint(-1 * ratio * speed);
		bottomPID.setSetpoint(-1 * speed);
		
		topPID.enable();
		bottomPID.enable();
    }
    
    public boolean isSpeedClose() {
		return (topPID.getError() < 1) && (bottomPID.getError() < 1);
    }

    public void endPID() {
		topPID.disable();
		bottomPID.disable();
    }
	
	public double getTopRate() {
		return topEncoder.getRate();
	}
	
	public double getBottomRate() {
		return bottomEncoder.getRate();
	}
}
