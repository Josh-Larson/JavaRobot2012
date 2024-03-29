package com.dwlarson.joshua.commands.collector;

import com.dwlarson.joshua.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Outputs the data from the collector in real-time
 * @author Josh Larson
 */
public class OutputCollectorData extends CommandBase {
	
	public OutputCollectorData() {
		requires(collector);
		setTimeout(0.05);
	}
	
	protected void initialize() {
		SmartDashboard.putDouble("Front IR", collector.getFrontIR());
		SmartDashboard.putDouble("Middle IR", collector.getMiddleIR());
		SmartDashboard.putDouble("Transition IR", collector.getTransitionIR());
		SmartDashboard.putDouble("Top IR", collector.getTopIR());
		SmartDashboard.putBoolean("Front IR Triggered", collector.frontTriggered());
		SmartDashboard.putBoolean("Middle IR Triggered", collector.middleTriggered());
		SmartDashboard.putBoolean("Transition IR Triggered", collector.transitionTriggered());
		SmartDashboard.putBoolean("Top IR Triggered", collector.topTriggered());
	}
	
	protected void execute() {
		
	}
	
	protected boolean isFinished() {
		return isTimedOut();
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		end();
	}
}
