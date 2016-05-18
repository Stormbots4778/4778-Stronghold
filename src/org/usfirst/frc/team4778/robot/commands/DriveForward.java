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
		
		powerPID = new PIDController(0.125, 0, 0, -12);
		powerPID.setOutputLimits(-1, 1);
		
		RobotMap.ahrs.reset();
		RobotMap.encoder.setDistancePerPulse(0.125488281);
		
		System.out.println("-end-init Breach");
	}

	protected void execute() {
		System.out.println("-exe Breach");

		double output = pid.computePID(RobotMap.ahrs.getYaw());
		double newPower = powerPID.computePID(RobotMap.encoder.getRate());
		
		//TODO Add fail safe - check if under 75% power after 100ms
		
		Robot.drivetrain.arcadeDrive(newPower, output);

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
