package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.pid.PIDController;

import edu.wpi.first.wpilibj.command.Command;

public class DriveOnDefence extends Command {

	PIDController pid;
	boolean isFinished = false;
	double power = 0;

	public DriveOnDefence(double power) {
		requires(Robot.drivetrain);
		this.power = power;
	}

	protected void initialize() {
		System.out.println("-init DriveOnDefense");
		
		pid = new PIDController(0.05, 0.04, 0.2, RobotMap.h);
		pid.setOutputLimits(-1, 1);
		pid.setTolerence(1);
		
		System.out.println("-end-init DriveOnDefense");
	}

	protected void execute() {
		System.out.println("-exe DriveOnDefense");
		
		double output = pid.computePID(RobotMap.gyro.getAngle());
		double angle = RobotMap.gy2.getAngle();
		double anglel = RobotMap.f - 5;
		double angleh = RobotMap.f + 5;
		Robot.drivetrain.arcadeDrive(power, output);
		if (angle < anglel ^ angle > angleh) {
			isFinished = true;
		}
		
		System.out.println("-end-exe DriveOnDefense");
	}

	protected void end() {
		Robot.drivetrain.arcadeDrive(0, 0);
		RobotMap.gy2.reset();
		
		System.out.println("-end DriveOnDefense");
	}

	protected boolean isFinished() {return isFinished;}
	protected void interrupted() {end();}
}
