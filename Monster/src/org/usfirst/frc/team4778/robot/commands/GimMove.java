package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GimMove extends Command {

	int angleU;
	int angle;
	boolean finished = false;

	public GimMove(int angU, int ang) {
		angleU = angU;
		angle = ang;
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.gimbal);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.gimbal.change(angleU, angle);
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
	}
}
