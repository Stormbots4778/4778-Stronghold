package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.pid.PIDController;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command {
	private PIDController pid;
	private PIDController powerPID;
	boolean isFinished = false;
	double power = 0;
	
	public DriveForward(double power) {
		requires(Robot.drivetrain);
		this.power = power;
	}

	protected void initialize() {
		System.out.println("-init Breach");
		RobotMap.direction = 1;
		pid = new PIDController(0.125, 0, 0, 0);
		pid.setOutputLimits(-1, 1);
		pid.setTolerence(3);
		
		powerPID = new PIDController(0.125, 0, 0, power);
		powerPID.setOutputLimits(-0.6, 0.6);
		powerPID.setTolerence(3);
		
		RobotMap.ahrs.reset();
		
		System.out.println("-end-init Breach");
	}

	protected void execute() {
		System.out.println("-exe Breach");

		double output = pid.computePID(RobotMap.ahrs.getYaw());
		double newPower = powerPID.computePID(RobotMap.ahrs.getVelocityX());
			
		Robot.drivetrain.arcadeDrive(newPower, output); //TODO Add PID for power

		System.out.println("-end-exe Breach");
	}

	protected void end() {
		try {
			wait(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Robot.drivetrain.arcadeDrive(0, 0);
		System.out.println("-end Breach");
	}

	protected boolean isFinished() {
		return isFinished;
	}

	protected void interrupted() {
		end();
	}
}
