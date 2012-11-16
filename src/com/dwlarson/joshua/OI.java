
package com.dwlarson.joshua;

import com.dwlarson.joshua.commands.CalibrateCollector;
import com.dwlarson.joshua.commands.DisableRobot;
import com.dwlarson.joshua.commands.DisabledButton;
import com.dwlarson.joshua.commands.MoveRampDown;
import com.dwlarson.joshua.commands.MoveRampUp;
import com.dwlarson.joshua.commands.ShootBall;
import com.dwlarson.joshua.commands.ToggleTankArcade;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.InternalButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.NetworkButton;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Stands for Operator Interface, this class holds the buttons
 * that are found on the driver's station. Such as joystick
 * or on-screen buttons via the SmartDashboard.
 * @author Josh Larson
 */
public class OI {
	public boolean arcade = true;
	private Joystick joy1;
	private Joystick joy2;
	
	private JoystickButton shootButton;
	private JoystickButton rampUpButton;
	private JoystickButton tankToggleButton;
	private JoystickButton rampDownButton;
	private InternalButton calibrateButton;
	private DisabledButton disableButton;
	
	public OI() {
		NetworkTable.initialize();
		
		joy1 = new Joystick(RobotMap.COMPUTER_JOYSTICK1);
		joy2 = new Joystick(RobotMap.COMPUTER_JOYSTICK2);
		
		shootButton      = new JoystickButton(joy1, RobotMap.JOYSTICK_SHOOT);
		rampUpButton     = new JoystickButton(joy1, RobotMap.JOYSTICK_RAMP_UP);
		tankToggleButton = new JoystickButton(joy1, RobotMap.JOYSTICK_TANK_ARCADE_TOGGLE);
		rampDownButton   = new JoystickButton(joy1, RobotMap.JOYSTICK_RAMP_DOWN);
		calibrateButton  = new InternalButton();
		disableButton    = new DisabledButton();
		
		SmartDashboard.putData("Calibrate", calibrateButton);
		
		shootButton.whenReleased(new ShootBall());
		rampUpButton.whileHeld(new MoveRampUp());
		tankToggleButton.whenReleased(new ToggleTankArcade());
		rampDownButton.whileHeld(new MoveRampDown());
		calibrateButton.whenPressed(new CalibrateCollector());
		//disableButton.whileHeld(new DisableRobot());
	}
	
	public Joystick getJoystick1() {
		return joy1;
	}
	
	public Joystick getJoystick2() {
		return joy2;
	}
	
	public void setArcadeDrive(boolean arcade) {
		this.arcade = arcade;
	}
	
	public boolean isArcadeDrive() {
		return arcade;
	}
}

