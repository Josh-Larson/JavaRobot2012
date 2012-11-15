package com.dwlarson.joshua.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Calibrates the collector
 * @author Josh Larson
 */
public class CalibrateCollector extends CommandBase {
	
	private Timer t;
	private double staticFront;
	private double staticMiddle;
	private double staticTransition;
	private double staticTop;
	private final double maxTime = 5.0;
	
	public CalibrateCollector() {
		requires(collector);
		t = new Timer();
	}
	
	protected void initialize() {
		t.stop();
		t.reset();
		t.start();
		staticFront = 0;
		staticMiddle = 0;
		staticTransition = 0;
		staticTop = 0;
		SmartDashboard.putDouble("CalibrationTimer", maxTime - t.get());
	}
	
	protected void execute() {
		SmartDashboard.putDouble("CalibrationTimer", maxTime - t.get());
		if (collector.getRawFrontIR() > staticFront) staticFront = collector.getRawFrontIR();
		if (collector.getRawMiddleIR() > staticMiddle) staticMiddle = collector.getRawMiddleIR();
		if (collector.getRawTransitionIR() > staticTransition) staticTransition = collector.getRawTransitionIR();
		if (collector.getRawTopIR() > staticTop) staticTop = collector.getRawTopIR();
	}
	
	protected boolean isFinished() {
		return t.get() >= maxTime;
	}
	
	protected void end() {
		SmartDashboard.putDouble("CalibrationTimer", maxTime - t.get());
		collector.setFrontSensitivity(staticFront);
		collector.setMiddleSensitivity(staticMiddle);
		collector.setTransitionSensitivity(staticTransition);
		collector.setTopSensitivity(staticTop);
	}
	
	protected void interrupted() {
		end();
	}
}
