package com.dwlarson.joshua.commands.collector;

import com.dwlarson.joshua.commands.CommandBase;

/**
 *
 * @author Josh Larson
 */
public class MoveBallIntoCollector extends CommandBase {
	
	public MoveBallIntoCollector() {
		requires(collector);
	}
	
	protected void initialize() {
		System.out.print("Disable?");
		if (collector.noneTriggered()) {
			collector.disable();
			System.out.println("  Yes, diabled.");
			return;
		}
		if (!collector.isCalibrated()) return;
		if (collector.frontTriggered()) {
			collector.moveIn();
		}
		if (collector.middleTriggered()) {
			collector.moveIn();
			collector.moveUp();
		}
		if (collector.transitionTriggered()) {
			collector.disable();
			collector.moveUp();
		}
		if (collector.topTriggered()) {
			collector.disable();
		}
	}
	
	protected void execute() {
		
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
		
	}

	protected void interrupted() {
		
	}
	
}
