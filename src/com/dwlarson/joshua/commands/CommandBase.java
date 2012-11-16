package com.dwlarson.joshua.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.dwlarson.joshua.OI;
import com.dwlarson.joshua.subsystems.Collector;
import com.dwlarson.joshua.subsystems.DriveTrain;
import com.dwlarson.joshua.subsystems.RampManipulator;
import com.dwlarson.joshua.subsystems.Shooter;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Josh Larson
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static      DriveTrain      driveTrain = new DriveTrain();
    public static RampManipulator rampManipulator = new RampManipulator();
    public static       Collector       collector = new Collector();
    public static         Shooter         shooter = new Shooter();

    public static void init() {
		// This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(driveTrain);
		SmartDashboard.putData(collector);
		SmartDashboard.putData(shooter);
		SmartDashboard.putData(rampManipulator);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
