package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import pid.PIDController;

/**
 *
 */
public class Move extends Command {

	boolean finished = false;
	double time = 0;
	double endTime = 0;
	boolean d = true;

	private PIDController pid;

	public Move(double t, boolean dir) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drivetrain);
		time = t;
		d = dir;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("-move-Int");
		endTime = Timer.getFPGATimestamp() + time;
		pid = new PIDController(0.05, 0.03, 0.2, 0);
		pid.setOnTargetOffset(1);
		pid.setOutputLimits(-1, 1);
		RobotMap.gyro.reset();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println("-move-exe");
		time = Timer.getFPGATimestamp();
		double out = pid.computePID(RobotMap.gyro.getAngle());
		if (d) {
			Robot.drivetrain.arcadeDrive(-0.85, out);
		} else {
			Robot.drivetrain.arcadeDrive(0.85, out);
		}
		if (endTime < time) {
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
		if (d) {
			Robot.drivetrain.stop(-0.2);
		} else {
			Robot.drivetrain.stop(0.2);
		}

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
