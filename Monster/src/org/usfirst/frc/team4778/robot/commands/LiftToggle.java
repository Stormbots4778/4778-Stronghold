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
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.lift.getarm()) {
			Robot.lift.moveArm(false);
		} else {
			Robot.lift.moveArm(true);
		}
		finished = true;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return finished;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
