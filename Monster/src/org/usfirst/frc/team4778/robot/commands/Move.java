package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Move extends Command {

	boolean finished = false;
	double time = 0;
	double endTime = 0;
	boolean f = true;

	public Move(double t) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drivetrain);
		time = t;
		if (time < 0) {
			Math.abs(time);
			f = false;
		}

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("-move-Int");
		endTime = Timer.getFPGATimestamp() + time;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println("-move-exe");
		time = Timer.getFPGATimestamp();
		if (f) {
			Robot.drivetrain.arcadeDrive(-0.85, 0);
		} else {
			Robot.drivetrain.arcadeDrive(0.85, 0);
		}
		if (endTime < time) {
			System.out.println("-move-done");
			finished = true;
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return finished;
	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println("-move-end");
		if (f) {
			Robot.drivetrain.stop(-0.5);
		} else {
			Robot.drivetrain.stop(0.5);
		}

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
