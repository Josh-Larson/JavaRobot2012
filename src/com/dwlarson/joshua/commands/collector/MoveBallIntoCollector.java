package com.dwlarson.joshua.commands.collector;

import com.dwlarson.joshua.commands.CommandBase;

/**
 * Moves the ball in the collector depending on which
 * sensors are activated
 * @author Josh Larson
 */
public class MoveBallIntoCollector extends CommandBase {
	
	private static int triggeredInRow = 5;
	
	public MoveBallIntoCollector() {
		requires(collector);
		setTimeout(0.05);
	}
	
	protected void initialize() {
		if (!collector.isCalibrated()) {
			return;
		}
		
		boolean front      = collector.frontTriggered(triggeredInRow);
		boolean middle     = collector.middleTriggered(triggeredInRow);
		boolean transition = collector.transitionTriggered(triggeredInRow);
		boolean top        = collector.topTriggered(triggeredInRow);
		boolean moved      = false;
		
		if (!front && middle) {
			collector.moveUp();
			moved = true;
		}
		if (front || middle) {
			collector.moveIn();
			moved = true;
		}
		if (!front && !middle) {
			collector.disableGrabber();
			moved = false;
		}
		
		if (transition) {
			collector.moveUp();
			try { Thread.sleep(1000); } catch (InterruptedException e) { }
			moved = true;
		}
		
		if (top) {
			collector.disableLifter();
		}
		
		if (!moved) {
			collector.disable();
		}
	}
	
	protected void execute() {
		
	}
	
	protected boolean isFinished() {
		return isTimedOut();
	}
	
	protected void end() {
		
	}

	protected void interrupted() {
		
	}
	
}
