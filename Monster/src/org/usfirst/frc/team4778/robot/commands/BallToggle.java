package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BallToggle extends Command {

	private boolean finished = false;

	public BallToggle() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.ball);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("-ball-init");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println("-ball-exe");
		if (Robot.ball.getArm()) {
			Robot.ball.moveArm(false);
		} else {
			Robot.ball.moveArm(true);
		}
		finished = true;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return finished;
	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println("-ball-end");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}