package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.pid.PIDController;

import edu.wpi.first.wpilibj.command.Command;

public class ExitDefence extends Command {

	private PIDController pid;
	boolean isFinished = false;
	double power = 0;

	public ExitDefence(double power) {
		requires(Robot.drivetrain);
		this.power = power;
	}

	protected void initialize() {
		System.out.println("-init ExitDefense");

		pid = new PIDController(0.05, 0.04, 0.2, RobotMap.h);
		pid.setOutputLimits(-1, 1);
		pid.setTolerence(1);
		RobotMap.direction = 1;

		System.out.println("-end-init ExitDefense");
	}

	protected void execute() {
		System.out.println("-exe ExitDefense");

		// double output = pid.computePID(RobotMap.gyro.getAngle());
		// double angle = RobotMap.gy2.getAngle();
		// Robot.drivetrain.arcadeDrive(power, output);
		// if (angle < -20) {
		isFinished = true;
		// }

		System.out.println("-end-exe ExitDefense");
	}

	protected void end() {
		Robot.drivetrain.arcadeDrive(0, 0);
		// RobotMap.gy2.reset();

		System.out.println("-end ExitDefense");
	}

	protected void interrupted() {
		end();
	}

	protected boolean isFinished() {
		return isFinished;
	}
}