package com.dwlarson.joshua;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int COMPUTER_JOYSTICK1          = 1;
	public static final int COMPUTER_JOYSTICK2          = 2;
	
	public static final int JOYSTICK_SHOOT              = 1;
	public static final int JOYSTICK_TURRET_MAN_TURN    = 2;
	public static final int JOYSTICK_RAMP_UP            = 3;
	public static final int JOYSTICK_TANK_ARCADE_TOGGLE = 4;
	public static final int JOYSTICK_RAMP_DOWN          = 5;
	public static final int JOYSTICK_EJECT_BALLS        = 6;
	
	public static final int DRIVETRAIN_JAGUAR_LEFT      = 1;
	public static final int DRIVETRAIN_JAGUAR_RIGHT     = 2;
	public static final int DRIVETRAIN_ENCODER_LEFT_A   = 1;
	public static final int DRIVETRAIN_ENCODER_LEFT_B   = 2;
	public static final int DRIVETRAIN_ENCODER_RIGHT_A  = 3;
	public static final int DRIVETRAIN_ENCODER_RIGHT_B  = 4;
	
	public static final int RAMPMANIPULATOR_VICTOR      = 8;
	public static final int RAMPMANIPULATOR_RELAY       = 1;
	
	public static final int COLLECTOR_VICTOR_LIFTER     = 5;
	public static final int COLLECTOR_VICTOR_GRABBER    = 6;
	public static final int COLLECTOR_FRONT_IR          = 1;
	public static final int COLLECTOR_MIDDLE_IR         = 2;
	public static final int COLLECTOR_TOP_IR            = 3;
	public static final int COLLECTOR_TRANSITION_IR     = 4;
	
	public static final int SHOOTER_JAGUAR_TOP          = 4;
	public static final int SHOOTER_JAGUAR_BOTTOM       = 3;
	public static final int SHOOTER_ENCODER_BOTTOM_A    = 5;
	public static final int SHOOTER_ENCODER_TOP_A       = 6;
	public static final int SHOOTER_VICTOR_TURRET       = 7;
	public static final int SHOOTER_ENCODER_PULSES_SEC  = 128;
	
	
	public static final double SHOOTER_SPEED_CONSTANT   = 27.7;
}
