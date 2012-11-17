package com.dwlarson.joshua.commands.collector;

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
	private final double maxTime = 7;
	private final double maxRange = 5;
	
	public CalibrateCollector() {
		requires(collector);
		t = new Timer();
	}
	
	protected void initialize() {
		t.stop();
		t.reset();
		t.start();
		filter = new double[4];
		value = new double[4];
		SmartDashboard.putDouble("CalibrationTimer", 0);
	}
	
	protected void execute() {
		value[0] = collector.getRawFrontIR();
		value[1] = collector.getRawMiddleIR();
		value[2] = collector.getRawTransitionIR();
		value[3] = collector.getRawTopIR();
		
		for (int i = 0; i < 4; i++) {
			if (value[i] > filter[i])
				filter[i] = (value[i] + filter[i]) / 2;
		}
		
		SmartDashboard.putDouble("CalibrationTimer", (maxTime - t.get()) * (maxRange / maxTime));
		SmartDashboard.putDouble("Front IR", filter[0]);
		SmartDashboard.putDouble("Middle IR", filter[1]);
		SmartDashboard.putDouble("Transition IR", filter[2]);
		SmartDashboard.putDouble("Top IR", filter[3]);
	}
	
	protected boolean isFinished() {
		return t.get() >= maxTime;
	}
	
	protected void end() {
		SmartDashboard.putDouble("CalibrationTimer", 0);
		collector.setFrontSensitivity(filter[0]);
		collector.setMiddleSensitivity(filter[1]);
		collector.setTransitionSensitivity(filter[2]);
		collector.setTopSensitivity(filter[3]);
		collector.setCalibrated(true);
	}
	
	protected void interrupted() {
		end();
	}
}
