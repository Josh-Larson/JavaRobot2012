package com.dwlarson.joshua.commands.collector;

import com.dwlarson.joshua.commands.CommandBase;

/**
 *
 * @author Josh Larson
 */
public class MoveBallThroughCollector extends CommandBase {
	
	public MoveBallThroughCollector() {
		requires(collector);
	}
	
	protected void initialize() {
		if (!collector.isCalibrated()) return;
		boolean anyMoved = false;
		if (collector.frontTriggered()) {
			collector.moveIn();
			anyMoved = true;
		}
		if (collector.middleTriggered()) {
			collector.moveIn();
			collector.moveUp();
			anyMoved = true;
		}
		if (collector.transitionTriggered()) {
			collector.disable();
			collector.moveUp();
			anyMoved = true;
		}
		if (collector.topTriggered()) {
			collector.disable();
			anyMoved = true;
		}
		if (!anyMoved) {
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
