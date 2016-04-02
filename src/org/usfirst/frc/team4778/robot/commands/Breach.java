package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.conversions.AccTools;
import org.usfirst.frc.team4778.robot.conversions.Slope;
import org.usfirst.frc.team4778.robot.pid.PIDController;

import edu.wpi.first.wpilibj.command.Command;

public class Breach extends Command {
	private PIDController pid;
	AccTools a = new AccTools(RobotMap.acc);
	Slope s = new Slope(RobotMap.acc);
	boolean isFinished = false;
	double power = 0;

	public Breach(double power) {
		requires(Robot.drivetrain);
		this.power = power;
	}

	protected void initialize() {
		System.out.println("-init Breach");

		//RobotMap.gy2.calibrate();
		RobotMap.direction = 1;
		pid = new PIDController(0.125, 0, 0, RobotMap.h);
		pid.setOutputLimits(-1, 1);
		pid.setTolerence(1);

		System.out.println("-end-init Breach");
	}

	protected void execute() {
		System.out.println("-exe Breach");
		
		boolean detectSlope = false;
		double slope = s.getSlope();
		//double output = pid.computePID(RobotMap.gyro.getAngle());
		double angle = a.getZ();
		if(slope <= -0.2) {
			detectSlope = true;
		}
		if(detectSlope == true) {
			if(slope >= 0.1) {
				isFinished = true;
			}
		}
			
		//Robot.drivetrain.arcadeDrive(power, output);

		System.out.println("-end-exe Breach");
	}

	protected void end() {
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
