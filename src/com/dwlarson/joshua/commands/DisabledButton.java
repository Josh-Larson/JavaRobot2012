package com.dwlarson.joshua.commands;

import com.dwlarson.joshua.Robot;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 *
 * @author Josh Larson
 */
public class DisabledButton extends Button {
	
	public boolean get() {
		return !Robot.disabled;
	}
}
