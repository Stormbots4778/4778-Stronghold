package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Breach extends Command {
	boolean finished = false;
	double endtime = 0;
	double time = 0;
	double flat = 0;
	boolean direction = true;

	public Breach(boolean dir, double tim) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drivetrain);
		time = tim;
		direction = dir;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		flat = RobotMap.acc.getZ();
		System.out.println("-breach-init");
		Robot.drivetrain.resetGyro();
		if (direction) {
			Robot.drivetrain.setSpeed(-0.85);
			Robot.drivetrain.setOutputRange(-1, 0);
		} else {
			Robot.drivetrain.setSpeed(0.85);
			Robot.drivetrain.setOutputRange(0, 1);
		}
		Robot.drivetrain.setSetpoint(0);
		Robot.drivetrain.getPIDController().setPID(0.05, 0.01, 0.2);
		Robot.drivetrain.enable();
		endtime = Timer.getFPGATimestamp() + time;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println("-breach-exe");
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
		System.out.println("-breach-end");
		Robot.drivetrain.disable();
		if (direction) {
			Robot.drivetrain.stop(0.3);
		} else {
			Robot.drivetrain.stop(-0.3);
		}

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
