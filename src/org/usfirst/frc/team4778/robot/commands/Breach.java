package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.pid.PIDController;

import edu.wpi.first.wpilibj.command.Command;

public class Breach extends Command {
	private PIDController pid;
	boolean isFinished = false;
	double power = 0;
	private boolean wentUp = false;
	private boolean wentUpAgain = false;
	private double h = 0;
	private boolean isMoat = false;
	private long startTime; 
	
	public Breach(double power, double h, boolean isMoat) {
		requires(Robot.drivetrain);
		this.power = power;
		this.h = h;
		this.isMoat = isMoat;
	}

	protected void initialize() {
		System.out.println("-init Breach");
		RobotMap.direction = 1;
		pid = new PIDController(0.125, 0, 0, h);
		pid.setOutputLimits(-1, 1);
		pid.setTolerence(3);

		RobotMap.ahrs.reset();
		
		System.out.println("-end-init Breach");
	}

	protected void execute() {
		System.out.println("-exe Breach");

		double output = pid.computePID(RobotMap.ahrs.getYaw());		
		double pitch = RobotMap.ahrs.getRoll();

		if(pitch <= -5) {
			if(wentUp) {
				wentUpAgain = true;
			}
			wentUp = true;
		}
		
		if(isMoat) {
			if(pitch > -1 && wentUpAgain) {
				isFinished = true;
			}
		} else {
			if(pitch > -1 && wentUp) {
				isFinished = true;
			}
		}
		
		if(wentUpAgain && pitch > -1) {
			isFinished = true;
		}
			
		Robot.drivetrain.arcadeDrive(power, output); //TODO Add PID for power

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
