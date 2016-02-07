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
		requires(Robot.drivetrain);
		angle = ang;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("-turn-init");
		Robot.drivetrain.resetGyro();
		Robot.drivetrain.setSpeed(0);
		Robot.drivetrain.setSetpoint(angle);
		Robot.drivetrain.getPIDController().setPID(0.02, 0, 0);
		Robot.drivetrain.setOutputRange(-1, 1);
		Robot.drivetrain.setAbsoluteTolerance(0.9);
		Robot.drivetrain.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println("-turn-exe");
		if (Robot.drivetrain.onTarget()) {
			finished = true;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return finished;
	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println("-turn-end");
		Robot.drivetrain.disable();
		;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
