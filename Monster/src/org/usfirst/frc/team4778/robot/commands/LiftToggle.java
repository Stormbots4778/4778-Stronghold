package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftToggle extends Command {

	private boolean finished = false;

	public LiftToggle() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.lift);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("-lift-init");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println("-lift-exe");
		if (Robot.lift.getstate()) {
			Robot.lift.move(false);
		} else {
			Robot.lift.move(true);
		}
		finished = true;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return finished;
	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println("-lift-end");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
