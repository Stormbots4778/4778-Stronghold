package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnToAngle extends Command {

	private boolean finished = false;
	private double angle;

	public TurnToAngle(double ang) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drive);
		angle = ang;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.drive.resetGyro();
		Robot.drive.setSpeed(0);
		Robot.drive.setSetpoint(angle);
		Robot.drive.getPIDController().setPID(0.2, 0, 0);
		Robot.drive.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.drive.onTarget()) {
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
