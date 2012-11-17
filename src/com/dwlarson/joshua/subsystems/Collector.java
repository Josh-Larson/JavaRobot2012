package com.dwlarson.joshua.subsystems;

import com.dwlarson.joshua.RobotMap;
import com.dwlarson.joshua.commands.collector.CollectorRunning;

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
	private int [] triggerInRow;
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
		
		triggerInRow = new int[4];
	}
	
	public void disable() {
		lifter.set(0);
		grabber.set(0);
	}
	
	public void disableGrabber() {
		grabber.set(0);
	}
	
	public void disableLifter() {
		lifter.set(0);
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
		if (getFrontIR() > 0) {
			triggerInRow[0]++;
			return true;
		} else {
			triggerInRow[0] = 0;
			return false;
		}
	}
	
	public boolean middleTriggered() {
		if (getMiddleIR() > 0) {
			triggerInRow[1]++;
			return true;
		} else {
			triggerInRow[1] = 0;
			return false;
		}
	}
	
	public boolean transitionTriggered() {
		if (getTransitionIR() > 0) {
			triggerInRow[2]++;
			return true;
		} else {
			triggerInRow[2] = 0;
			return false;
		}
	}
	
	public boolean topTriggered() {
		if (getTopIR() > 0) {
			triggerInRow[3]++;
			return true;
		} else {
			triggerInRow[3] = 0;
			return false;
		}
	}
	
	public boolean frontTriggered(int trigger) {
		frontTriggered();
		return triggerInRow[0] >= trigger;
	}
	
	public boolean middleTriggered(int trigger) {
		middleTriggered();
		return triggerInRow[1] >= trigger;
	}
	
	public boolean transitionTriggered(int trigger) {
		transitionTriggered();
		return triggerInRow[2] >= trigger;
	}
	
	public boolean topTriggered(int trigger) {
		topTriggered();
		return triggerInRow[3] >= trigger;
	}
	
	public boolean noneTriggered() {
		return !(frontTriggered() && middleTriggered() && transitionTriggered() && topTriggered());
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
}
