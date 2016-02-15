package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TestPID extends Command {

	double endtime = 0;
	double time = 0;
	boolean calib = true;

	public TestPID(boolean cal) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drivetrain);
		calib = cal;

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("-TestPID-init");
		// Robot.drivetrain.resetGyro();
		if (calib) {
			Robot.drivetrain.setSpeed(-0.85);
			Robot.drivetrain.setOutputRange(-1, 1);
			Robot.drivetrain.getPIDController().setPID(0.05, 0.03, 0.2);
			Robot.drivetrain.enable();
		} else {
			Robot.drivetrain.setSpeed(0);
			Robot.drivetrain.setOutputRange(-1, 1);
			Robot.drivetrain.resetGyro();
		}
		Robot.drivetrain.setSetpoint(0);
		// Robot.drivetrain.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drivetrain.setInput(RobotMap.gyro.getAngle());
		System.out.println("-TestPID-exe");
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println("-TestPID-end");
		Robot.drivetrain.disable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
