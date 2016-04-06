package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.pid.PIDController;

import edu.wpi.first.wpilibj.command.Command;

public class BreachLow extends Command {
	private PIDController pid;
	boolean isFinished = false;
	double power = 0;
	boolean wentUp = false;

	public BreachLow(double power) {
		requires(Robot.drivetrain);
		this.power = power;
	}

	protected void initialize() {
		System.out.println("-init Low-Breach");

		RobotMap.direction = 1;
		pid = new PIDController(0.125, 0, 0, 0);
		pid.setOutputLimits(-1, 1);
		pid.setTolerence(3);

		System.out.println("-end-init Low-Breach");
	}

	protected void execute() {
		System.out.println("-exe Low-Breach");

		// vroom vroom...
		double output = pid.computePID(RobotMap.ahrs.getYaw());
		Robot.drivetrain.arcadeDrive(power, output);

		double pitch = RobotMap.ahrs.getRoll();
		
		if (pitch <= -5) {
			wentUp = true;
		}
		
		if(pitch > -1 && wentUp) {
			isFinished = true;
		}

		System.out.println("-end-exe Low-Breach");
	}

	protected void end() {
		Robot.drivetrain.arcadeDrive(0, 0);

		System.out.println("-end Low-Breach");
	}

	protected boolean isFinished() {
		return isFinished;
	}

	protected void interrupted() {
		end();
	}
}
