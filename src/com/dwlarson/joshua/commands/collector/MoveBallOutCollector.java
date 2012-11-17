package com.dwlarson.joshua.commands.collector;

import com.dwlarson.joshua.commands.CommandBase;

/**
 * Moves the ball out of the collector depending on which
 * sensors are activated
 * @author Josh Larson
 */
public class MoveBallOutCollector extends CommandBase {
	
	private static int triggeredInRow = 5;
	
	public MoveBallOutCollector() {
		requires(collector);
	}
	
	protected void initialize() {
		if (!collector.isCalibrated()) {
			return;
		}
		
		boolean front      = collector.frontTriggered(triggeredInRow);
		boolean middle     = collector.middleTriggered(triggeredInRow);
		boolean transition = collector.transitionTriggered(triggeredInRow);
		boolean top        = collector.topTriggered(triggeredInRow);
		
		collector.moveDown();
		
		if (top) {
			collector.moveDown();
		}
		
		if (transition) {
			collector.moveOut();
		}
		
		if (middle) {
			collector.disableLifter();
			collector.moveOut();
		}
		
		if (front) {
			collector.moveOut();
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
