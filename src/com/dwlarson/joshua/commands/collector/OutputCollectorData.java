package com.dwlarson.joshua.commands.collector;

import com.dwlarson.joshua.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Outputs the data from the collector in real-time
 * @author Josh Larson
 */
public class OutputCollectorData extends CommandBase {
	
	private double [] voltages;
	
	public OutputCollectorData() {
		requires(collector);
		voltages = new double[4];
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		for (int s = 0; s < 50; s++) {
			voltages[0] += collector.getFrontIR();
			voltages[1] += collector.getMiddleIR();
			voltages[2] += collector.getTransitionIR();
			voltages[3] += collector.getTopIR();
			try { Thread.sleep(1); } catch (InterruptedException e) { }
		}
		for (int i = 0; i < 4; i++)
			voltages[i] /= 50;
		
		SmartDashboard.putDouble("Front IR", voltages[0]);
		SmartDashboard.putDouble("Middle IR", voltages[1]);
		SmartDashboard.putDouble("Transition IR", voltages[2]);
		SmartDashboard.putDouble("Top IR", voltages[3]);
		SmartDashboard.putBoolean("Front IR Triggered", collector.frontTriggered());
		SmartDashboard.putBoolean("Middle IR Triggered", collector.middleTriggered());
		SmartDashboard.putBoolean("Transition IR Triggered", collector.transitionTriggered());
		SmartDashboard.putBoolean("Top IR Triggered", collector.topTriggered());
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		end();
	}
}
