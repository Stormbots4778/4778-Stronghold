package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.pid.PIDController;

import edu.wpi.first.wpilibj.command.Command;

public class DriveOntoDefence extends Command {

	PIDController pid;
	boolean isFinished = false;
	double power = 0;

	public DriveOntoDefence(double power) {
		requires(Robot.drivetrain);
		this.power = power;
	}

	protected void initialize() {
		System.out.println("-init DriveOntoDefense");

		RobotMap.direction = 1;
		pid = new PIDController(0.125, 0, 0, 0);
		pid.setOutputLimits(-1, 1);
		pid.setTolerence(3);

		System.out.println("-end-init DriveOntoDefense");
	}

	protected void execute() {
		System.out.println("-exe DriveOntoDefense");
		
		double pitch = RobotMap.ahrs.getRoll();
		if(pitch >= -5) {
			isFinished = true;
		}
		
		// Makes robot go vroom vroom
		double output = pid.computePID(RobotMap.ahrs.getYaw());
		Robot.drivetrain.arcadeDrive(power, output);

		System.out.println("-end-exe DriveOntoDefense");
	}

	protected void end() {
		Robot.drivetrain.arcadeDrive(0, 0);
		// RobotMap.gy2.reset();

		System.out.println("-end DriveOntoDefense");
	}

	protected boolean isFinished() {
		return isFinished;
	}

	protected void interrupted() {
		end();
	}
}
