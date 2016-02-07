package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Breach extends Command {
	private boolean finished = false;
	private double endtime = 0;
	private double time = 0;
	private boolean direction = true;

	public Breach(boolean dir) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drive);
		direction = dir;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.drive.resetGyro();
		if (direction) {
			Robot.drive.setSpeed(-0.85);
		} else {
			Robot.drive.setSpeed(0.85);
		}
		Robot.drive.setSetpoint(0);
		Robot.drive.getPIDController().setPID(1, 0, 0);
		Robot.drive.enable();
		endtime = Timer.getFPGATimestamp() + 3;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		time = Timer.getFPGATimestamp();
		if (time > endtime) {
			finished = true;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return finished;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drive.disable();
		Robot.drive.Stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
