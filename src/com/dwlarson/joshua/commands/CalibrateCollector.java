package com.dwlarson.joshua.commands;

import com.sun.squawk.util.Arrays;
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
	private double [] average;
	private double [] ballFilter;
	private int [] samplesAbove;
	private int sampleCount;
	private int maxSamples;
	private boolean done;
	private int step;
	private final double maxTime = 2.0;
	
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
		average = new double[4];
		ballFilter = new double[4];
		samplesAbove = new int[4];
		sampleCount = 0;
		maxSamples = 10;
		done = false;
		step = 0;
		SmartDashboard.putDouble("CalibrationTimer", maxTime - t.get());
	}
	
	protected void execute() {
		if (done) return;
		if (t.get() < maxTime) {
			SmartDashboard.putDouble("CalibrationTimer", maxTime - t.get());
			getSamples();
			
			/*sampleCount++;
			for (int i = 0; i < 4; i++) {
				average[i] += value[i];
				average[i] /= sampleCount;
				if (average[i] > filter[i]) {
					filter[i] = average[i];
				}
			}*/
			for (int i = 0; i < 4; i++)
				if (value[i] > filter[i]) filter[i] = value[i];
			
			SmartDashboard.putDouble("Front IR", filter[0]);
			SmartDashboard.putDouble("Middle IR", filter[1]);
			SmartDashboard.putDouble("Transition IR", filter[2]);
			SmartDashboard.putDouble("Top IR", filter[3]);
		} else {
			if (step == 0) {
				step = 1;
				sampleCount = 0;
			} else if (step == 1) {
				moveBallIn();
				if (done) {
					step = 2;
					done = false;
				}
			} else if (step == 2) {
				moveBallOut();
				if (done) {
					collector.setFrontBallSensitivity(filter[0] + (ballFilter[0] - filter[0]) * .2);
					collector.setMiddleBallSensitivity(filter[1] + (ballFilter[1] - filter[1]) * .2);
					collector.setTransitionBallSensitivity(filter[2] + (ballFilter[2] - filter[2]) * .2);
					collector.setTopBallSensitivity(filter[3] + (ballFilter[3] - filter[3]) * .2);
					collector.disable();
					collector.setCalibrated(true);
				}
			}
		}
	}
	
	protected boolean isFinished() {
		return done;
	}
	
	protected void end() {
		SmartDashboard.putDouble("CalibrationTimer", maxTime - t.get());
		collector.setFrontSensitivity(filter[0]);
		collector.setMiddleSensitivity(filter[1]);
		collector.setTransitionSensitivity(filter[2]);
		collector.setTopSensitivity(filter[3]);
	}
	
	protected void interrupted() {
		end();
	}
	
	private void getSamples() {
		value[0] = collector.getRawFrontIR();
		value[1] = collector.getRawMiddleIR();
		value[2] = collector.getRawTransitionIR();
		value[3] = collector.getRawTopIR();
	}
	
	private void moveBallIn() {
		getSamples();
		for (int i = 0; i < 4; i++) {
			if (value[i] > filter[i]) {
				if (value[i] > ballFilter[i]) ballFilter[i] = value[i];
				samplesAbove[i]++;
			}
		}
		sampleCount++;
		if (sampleCount == maxSamples) {
			sampleCount = 0;
			String stage = "-----";
			for (int i = 0; i < 4; i++) {
				if (samplesAbove[i] >= maxSamples * .7) {
					samplesAbove[i] = 0;
					if (i == 0) {
						collector.moveIn();
						stage = "Front";
						break;
					} else if (i == 1) {
						collector.moveIn();
						collector.moveSlowUp();
						stage = "Middle";
						break;
					} else if (i == 2) {
						collector.disable();
						collector.moveSlowUp();
						stage = "Transaction";
						break;
					} else if (i == 3) {
						collector.disable();
						done = true;
						stage = "Top";
						break;
					}
				} else {
					samplesAbove[i] = 0;
				}
			}
			SmartDashboard.putDouble("CalibrationTimer", 0);
			SmartDashboard.putString("CalibrationStage", stage);
			SmartDashboard.putDouble("Front IR", value[0] - filter[0]);
			SmartDashboard.putDouble("Middle IR", value[1] - filter[1]);
			SmartDashboard.putDouble("Transition IR", value[2] - filter[2]);
			SmartDashboard.putDouble("Top IR", value[3] - filter[3]);
		}
	}
	
	private void moveBallOut() {
		getSamples();
		for (int i = 0; i < 4; i++) {
			if (value[i] > filter[i]) {
				samplesAbove[i]++;
			}
		}
		sampleCount++;
		if (sampleCount == maxSamples) {
			sampleCount = 0;
			String stage = "-----";
			for (int i = 0; i < 4; i++) {
				if (samplesAbove[i] >= maxSamples * .7) {
					samplesAbove[i] = 0;
					if (i == 0) {
						collector.disable();
						stage = "Front";
						done = true;
						break;
					} else if (i == 1) {
						collector.moveOut();
						stage = "Middle";
						break;
					} else if (i == 2) {
						collector.moveDown();
						collector.moveOut();
						stage = "Transaction";
						break;
					} else if (i == 3) {
						collector.moveDown();
						stage = "Top";
						break;
					} else {
						collector.disable();
						stage = "-----";
					}
				} else {
					samplesAbove[i] = 0;
				}
			}
			SmartDashboard.putDouble("CalibrationTimer", 0);
			SmartDashboard.putString("CalibrationStage", stage);
			SmartDashboard.putDouble("Front IR", value[0] - filter[0]);
			SmartDashboard.putDouble("Middle IR", value[1] - filter[1]);
			SmartDashboard.putDouble("Transition IR", value[2] - filter[2]);
			SmartDashboard.putDouble("Top IR", value[3] - filter[3]);
		}
	}
}
