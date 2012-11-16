package com.dwlarson.joshua.subsystems;

import com.dwlarson.joshua.RobotMap;
import com.dwlarson.joshua.commands.CollectorRunning;
import com.dwlarson.joshua.commands.OutputCollectorData;

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
	private double frontIRBallVoltage;
	private double middleIRBallVoltage;
	private double transitionIRBallVoltage;
	private double topIRBallVoltage;
	private boolean calibrated;
	
	public void initDefaultCommand() {
		setDefaultCommand(new CollectorRunning());
	}
	
	public Collector() {
		lifter       = new Victor(RobotMap.COLLECTOR_VICTOR_LIFTER);
		grabber      = new Victor(RobotMap.COLLECTOR_VICTOR_GRABBER);
		frontIR      = new AnalogChannel(RobotMap.COLLECTOR_FRONT_IR);
		middleIR     = new AnalogChannel(RobotMap.COLLECTOR_MIDDLE_IR);
		transitionIR = new AnalogChannel(RobotMap.COLLECTOR_TRANSITION_IR);
		topIR        = new AnalogChannel(RobotMap.COLLECTOR_TOP_IR);
		
		calibrated = false;
		
		frontIRVoltage = 0;
		middleIRVoltage = 0;
		transitionIRVoltage = 0;
		topIRVoltage = 0;
		
		frontIRBallVoltage = 0;
		middleIRBallVoltage = 0;
		transitionIRBallVoltage = 0;
		topIRVoltage = 0;
	}
	
	public void disable() {
		lifter.set(0);
		grabber.set(0);
	}
	
	public void moveIn() {
		grabber.set(1);
	}
	
	public void moveOut() {
		grabber.set(-1);
	}
	
	public void moveUp() {
		lifter.set(0.7);
	}
	
	public void moveDown() {
		lifter.set(-1);
	}
	
	public void moveSlowIn() {
		grabber.set(0.5);
	}
	
	public void moveSlowOut() {
		grabber.set(-0.5);
	}
	
	public void moveSlowUp() {
		lifter.set(0.5);
	}
	
	public void moveSlowDown() {
		lifter.set(-0.5);
	}
	
	public void setCalibrated(boolean calibrated) {
		this.calibrated = calibrated;
	}
	
	public boolean isCalibrated() {
		return calibrated;
	}
	
	public boolean frontTriggered() {
		return frontIR.getVoltage() > frontIRBallVoltage;
	}
	
	public boolean middleTriggered() {
		return middleIR.getVoltage() > middleIRBallVoltage;
	}
	
	public boolean transitionTriggered() {
		return transitionIR.getVoltage() > transitionIRBallVoltage;
	}
	
	public boolean topTriggered() {
		return topIR.getVoltage() > topIRBallVoltage;
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
	
	public double getFrontIR() {
		return frontIR.getVoltage() - frontIRVoltage;
	}
	
	public double getMiddleIR() {
		return middleIR.getVoltage() - middleIRVoltage;
	}
	
	public double getTransitionIR() {
		return transitionIR.getVoltage() - transitionIRVoltage;
	}
	
	public double getTopIR() {
		return topIR.getVoltage() - topIRVoltage;
	}
	
	public double getRawFrontIR() {
		return frontIR.getVoltage();
	}
	
	public double getRawMiddleIR() {
		return middleIR.getVoltage();
	}
	
	public double getRawTransitionIR() {
		return transitionIR.getVoltage();
	}
	
	public double getRawTopIR() {
		return topIR.getVoltage();
	}
	
	public void setFrontBallSensitivity(double s) {
		frontIRBallVoltage = s;
	}
	
	public void setMiddleBallSensitivity(double s) {
		middleIRBallVoltage = s;
	}
	
	public void setTransitionBallSensitivity(double s) {
		transitionIRBallVoltage = s;
	}
	
	public void setTopBallSensitivity(double s) {
		topIRBallVoltage = s;
	}
}
