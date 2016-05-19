package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.pid.PIDController;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command {
	private PIDController pid;
	private PIDController powerPID;
	boolean isFinished = false;
	double power = 0;
	double failSafeEndTime;
	double failSafeIgnoreTime;
	
	public DriveForward(double power) {
		requires(Robot.drivetrain);
		this.power = power;
	}

	protected void initialize() {
		System.out.println("-init DriveForward");
		RobotMap.direction = 1;
		pid = new PIDController(0.125, 0, 0, 0);
		pid.setOutputLimits(-1, 1);
		pid.setTolerence(3);
		
		powerPID = new PIDController(0.5, 0.001, 0, -power);
		powerPID.setOutputLimits(-1, 1);
		
		RobotMap.ahrs.reset();
		RobotMap.encoder.setDistancePerPulse(0.125488281);
		
		failSafeEndTime = Timer.getFPGATimestamp() + 0.1;
		failSafeIgnoreTime = Timer.getFPGATimestamp() + 0.2;
		
		System.out.println("-end-init DriveForward");
	}

	protected void execute() {
		System.out.println("-exe DriveForward");

		double output = pid.computePID(RobotMap.ahrs.getYaw());
		double newPower = powerPID.computePID(RobotMap.encoder.getRate());
		
//		if (Timer.getFPGATimestamp() > failSafeIgnoreTime) { 
//			if ((Timer.getFPGATimestamp() > failSafeEndTime) && newPower < 0.75) {
//				isFinished = true;
//			}
//		}
//		
		Robot.drivetrain.arcadeDrive(newPower, output);

		System.out.println("-end-exe DriveForward");
	}

	protected void end() {
		Robot.drivetrain.arcadeDrive(0, 0);
		System.out.println("-end DriveForward");
	}

	protected boolean isFinished() {
		return isFinished;
	}

	protected void interrupted() {
		end();
	}
}
