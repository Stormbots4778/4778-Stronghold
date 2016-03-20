package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import pid.PIDController;

/**
 *
 */
public class Breach extends Command {
	boolean finished = false;
	double power = 0;
	boolean active = false;
	private PIDController pid;

	public Breach(double pow) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drivetrain);
		power = pow;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("-breach-init");
		RobotMap.dir = true;
		pid = new PIDController(0.05, 0.04, 0.2, RobotMap.h);
		pid.setOutputLimits(-1, 1);
		pid.setTolerence(1);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println("-breach-exe");
		double output = pid.computePID(RobotMap.gyro.getAngle());
		double angle = RobotMap.gy2.getAngle();
		double anglel = RobotMap.f - 5;
		double angleh = RobotMap.f + 5;
		Robot.drivetrain.arcadeDrive(power, output);
		if (active) {
			if (angle < -20) {
				finished = true;
			}
		} else {
			if (angle < anglel ^ angle > angleh) {
				active = true;
			}
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return finished;
	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println("-breach-end");
		// Robot.drivetrain.stop();
		Robot.drivetrain.arcadeDrive(0, 0);
		RobotMap.gy2.reset();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
