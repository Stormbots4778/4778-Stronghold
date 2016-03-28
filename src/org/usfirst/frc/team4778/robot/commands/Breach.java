package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.pid.PIDController;

import edu.wpi.first.wpilibj.command.Command;

public class Breach extends Command {
	private PIDController pid;
	boolean isFinished = false;
	boolean isActive = false;
	double power = 0;

	public Breach(double power) {
		requires(Robot.drivetrain);
		this.power = power;
	}

	protected void initialize() {
		System.out.println("-init Breach");

		RobotMap.gy2.calibrate();
		RobotMap.direction = 1;
		pid = new PIDController(0.125, 0, 0, RobotMap.h);
		pid.setOutputLimits(-1, 1);
		pid.setTolerence(1);

		System.out.println("-end-init Breach");
	}

	protected void execute() {
		System.out.println("-exe Breach");

		double output = pid.computePID(RobotMap.gyro.getAngle());
		double angle = RobotMap.gy2.getAngle();
		double anglel = RobotMap.f - 2;
		double angleh = RobotMap.f + 2;

		Robot.drivetrain.arcadeDrive(power, output);

		if (isActive) {
			if (angle > anglel && angle < angleh) {
				isFinished = true;
			}
		} else {
			if (angle < anglel ^ angle > angleh) {
				isActive = true;
			}
		}

		System.out.println("-end-exe Breach");
	}

	protected void end() {
		Robot.drivetrain.arcadeDrive(0, 0);
		RobotMap.gy2.reset();

		System.out.println("-end Breach");
	}

	protected boolean isFinished() {
		return isFinished;
	}

	protected void interrupted() {
		end();
	}
}
