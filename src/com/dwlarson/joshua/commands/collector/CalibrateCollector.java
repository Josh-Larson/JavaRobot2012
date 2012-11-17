package com.dwlarson.joshua.commands.collector;

import java.util.Date;

import com.dwlarson.joshua.commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Calibrates the collector
 * @author Josh Larson
 */
public class CalibrateCollector extends CommandBase {
	
	private Timer t;
	private double [] filter;
	private double [] value;
	private double [] lastValue;
	private double [] ballFilter;
	private int [] samplesAbove;
	private int sampleCount;
	private int maxSamples;
	private boolean done;
	private int step;
	private final double maxTime = 10;
	private final double maxRange = 5;
	
	public CalibrateCollector() {
		requires(collector);
		if (collector.isCalibrated()) done = true;
		t = new Timer();
	}
	
	protected void initialize() {
		t.stop();
		t.reset();
		t.start();
		filter = new double[4];
		value = new double[4];
		lastValue = new double[4];
		ballFilter = new double[4];
		samplesAbove = new int[4];
		sampleCount = 0;
		maxSamples = 20;
		done = false;
		step = 0;
		SmartDashboard.putDouble("CalibrationTimer", getTimeLeft());
	}
	
	protected void execute() {
		if (done) return;
		if (t.get() < maxTime) {
			SmartDashboard.putDouble("CalibrationTimer", getTimeLeft());
			getSamples(1);
			
			sampleCount++;
			for (int i = 0; i < 4; i++) {
				if (value[i] > filter[i]) filter[i] = value[i];
				value[i] = 0;
			}
			
			SmartDashboard.putDouble("Front IR", filter[0]);
			SmartDashboard.putDouble("Middle IR", filter[1]);
			SmartDashboard.putDouble("Transition IR", filter[2]);
			SmartDashboard.putDouble("Top IR", filter[3]);
		} else {
			done = true;
		}
	}
	
	protected boolean isFinished() {
		return done;
	}
	
	protected void end() {
		SmartDashboard.putDouble("CalibrationTimer", getTimeLeft());
		collector.setFrontSensitivity(filter[0]);
		collector.setMiddleSensitivity(filter[1]);
		collector.setTransitionSensitivity(filter[2]);
		collector.setTopSensitivity(filter[3]);
	}
	
	protected void interrupted() {
		end();
	}
	
	private void getSamples(int num) {
		for (int i = 0; i < num; i++) {
			value[0] += collector.getFrontIR();
			value[1] += collector.getMiddleIR();
			value[2] += collector.getTransitionIR();
			value[3] += collector.getTopIR();
			try { Thread.sleep(1); } catch (Exception e) { }
		}
		for (int i = 0; i < 4; i++) 
			value[i] /= num;
	}
	
	private double getTimeLeft() {
		return (maxTime - t.get()) * (maxRange / maxTime);
	}
}
