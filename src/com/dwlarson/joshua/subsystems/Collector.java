package com.dwlarson.joshua.subsystems;

import com.dwlarson.joshua.RobotMap;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The collector gets the balls from the ground and brings
 * them up until it goes out the shooter or is ejected for
 * one reason or another.
 * @author Josh Larson
 */
public class Collector extends Subsystem {
	
	private Victor lifter;
	private Victor grabber;
	private AnalogChannel frontIR;
	private AnalogChannel middleIR;
	private AnalogChannel transitionIR;
	private AnalogChannel topIR;
	private double frontIRVoltage;
	private double middleIRVoltage;
	private double transitionIRVoltage;
	private double topIRVoltage;
	
	public void initDefaultCommand() {
		
	}
	
	public Collector() {
		lifter       = new Victor(RobotMap.COLLECTOR_VICTOR_LIFTER);
		grabber      = new Victor(RobotMap.COLLECTOR_VICTOR_GRABBER);
		frontIR      = new AnalogChannel(RobotMap.COLLECTOR_FRONT_IR);
		middleIR     = new AnalogChannel(RobotMap.COLLECTOR_MIDDLE_IR);
		transitionIR = new AnalogChannel(RobotMap.COLLECTOR_TRANSITION_IR);
		topIR        = new AnalogChannel(RobotMap.COLLECTOR_TOP_IR);
		
		frontIRVoltage = 0;
		middleIRVoltage = 0;
		transitionIRVoltage = 0;
		topIRVoltage = 0;
	}
	
	public void moveIn() {
		grabber.set(1);
	}
	
	public void moveOut() {
		grabber.set(-1);
	}
	
	public void moveUp() {
		lifter.set(1);
	}
	
	public void moveDown() {
		lifter.set(-1);
	}
	
	public boolean frontTriggered() {
		return topIR.getVoltage() > frontIRVoltage;
	}
	
	public boolean middleTriggered() {
		return topIR.getVoltage() > middleIRVoltage;
	}
	
	public boolean transitionTriggered() {
		return topIR.getVoltage() > transitionIRVoltage;
	}
	
	public boolean topTriggered() {
		return topIR.getVoltage() > topIRVoltage;
	}
	
	public void setFrontSensitivity(double s) {
		frontIRVoltage = s;
	}
	
	public void setMiddleSensitivity(double s) {
		middleIRVoltage = s;
	}
	
	public void setTransitionSensitivity(double s) {
		transitionIRVoltage = s;
	}
	
	public void setTopSensitivity(double s) {
		topIRVoltage = s;
	}
	
}
