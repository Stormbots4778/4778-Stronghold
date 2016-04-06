package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.pid.PIDController;

import edu.wpi.first.wpilibj.command.Command;

public class ExitDefense extends Command {

	private PIDController pid;
	boolean isFinished = false;
	double power = 0;

	public ExitDefense(double power) {
		requires(Robot.drivetrain);
		this.power = power;
	}

	protected void initialize() {
		System.out.println("-init ExitDefense");

		RobotMap.direction = 1;
		pid = new PIDController(0.125, 0, 0, 0);
		pid.setOutputLimits(-1, 1);
		pid.setTolerence(3);

		System.out.println("-end-init ExitDefense");
	}

	protected void execute() {
		System.out.println("-exe ExitDefense");
		
		double pitch = RobotMap.ahrs.getRoll();
		if(pitch < 0) {
			isFinished = true;
		}
		
		double output = pid.computePID(RobotMap.ahrs.getYaw());
		Robot.drivetrain.arcadeDrive(power, output);
		
		System.out.println("-end-exe ExitDefense");
	}

	protected void end() {
		Robot.drivetrain.arcadeDrive(0, 0);

		System.out.println("-end ExitDefense");
	}

	protected void interrupted() {
		end();
	}

	protected boolean isFinished() {
		return isFinished;
	}
}