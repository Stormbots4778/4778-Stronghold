package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.pid.PIDController;

import edu.wpi.first.wpilibj.command.Command;

public class EnterDefense extends Command {

	PIDController pid;
	boolean isFinished = false;
	double power = 0;

	public EnterDefense(double power) {
		requires(Robot.drivetrain);
		this.power = power;
	}

	protected void initialize() {
		System.out.println("-init EnterDefense");

		RobotMap.direction = 1;
		pid = new PIDController(0.125, 0, 0, 0);
		pid.setOutputLimits(-1, 1);
		pid.setTolerence(3);

		System.out.println("-end-init EnterDefense");
	}

	protected void execute() {
		System.out.println("-exe EnterDefense");
		
		double pitch = RobotMap.ahrs.getRoll();
		if(pitch <= -5) {
			isFinished = true;
		}
		
		/*/
		 * Makes robot go vroom() {
		 *   vroom();
		 * }
		*/
		double output = pid.computePID(RobotMap.ahrs.getYaw());
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
