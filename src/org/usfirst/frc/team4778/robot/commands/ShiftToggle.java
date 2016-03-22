package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShiftToggle extends Command {

	boolean finished = false;

	public ShiftToggle() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.shift);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("-shift-init");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println("-shift-exe");
		if (Robot.shift.getstate()) {
			Robot.shift.shift(false);
		} else {
			Robot.shift.shift(true);
		}
		finished = true;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return finished;
	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println("-shift-end");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
