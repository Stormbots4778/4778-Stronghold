package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.pid.PIDController;

import edu.wpi.first.wpilibj.command.Command;

public class EnterDefense extends Command {

	PIDController pid;
	boolean isFinished = false;
	double power = 0;
	double rate = 0;
	
	double output = 0;
	
	double initPitch = 0;
	double pitch = 0.0;
	
	public EnterDefense(double power, double rate) {
		requires(Robot.drivetrain);
		this.power = power;
		this.rate = rate;
	}

	protected void initialize() {
		System.out.println("-init EnterDefense");

		RobotMap.direction = 1;
		pid = new PIDController(0.125, 0, 0, 1);
		pid.setOutputLimits(-1, 1);
		pid.setTolerence(3);

		initPitch = RobotMap.ahrs.getRoll();
		
		System.out.println("-end-init EnterDefense");
	}

	protected void execute() {
		System.out.println("-exe EnterDefense");
		
		pitch = RobotMap.ahrs.getRoll();
		
		if(pitch > initPitch + 2) {
			isFinished = true;
		}
		
		// TODO velocity and stray values
		
		double output = pid.computePID(RobotMap.ahrs.getYaw());
		//output += pid.computePID(RobotMap.leftdrive.getRate());
		Robot.drivetrain.arcadeDrive(power, output);

		System.out.println("-end-exe EnterDefense");
	}

	protected void end() {
		Robot.drivetrain.arcadeDrive(0, 0);

		System.out.println("-end EnterDefense");
	}

	protected boolean isFinished() {
		return isFinished;
	}

	protected void interrupted() {
		end();
	}
}
