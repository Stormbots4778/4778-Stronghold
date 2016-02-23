package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import conversions.AccToAngle;
import edu.wpi.first.wpilibj.command.Command;
import pid.PIDController;

/**
 *
 */
public class Breach extends Command {
	boolean finished = false;
	boolean direction = true;
	boolean onDefence = false;
	private PIDController pid;

	private AccToAngle aa = new AccToAngle(RobotMap.acc);

	public Breach(boolean dir) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drivetrain);
		direction = dir;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("-breach-init");
		RobotMap.dir = true;
		RobotMap.gyro.reset();
		pid = new PIDController(0.05, 0.03, 0.2, 0);
		pid.setOutputLimits(-1, 1);
		pid.setOnTargetOffset(2);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println("-breach-exe");
		double output = pid.computePID(RobotMap.gyro.getAngle());
		double angle = aa.getXRotation();
		if (direction == true) {
			Robot.drivetrain.arcadeDrive(-0.85, output);
		} else {
			Robot.drivetrain.arcadeDrive(0.85, output);
		}
		if (angle < 14.5 || angle > -14.5) {
			if (onDefence == true) {
				finished = true;
			}
		} else {
			onDefence = true;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return finished;
	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println("-breach-end");
		if (direction) {
			Robot.drivetrain.stop(0.2);
		} else {
			Robot.drivetrain.stop(-0.2);
		}

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
