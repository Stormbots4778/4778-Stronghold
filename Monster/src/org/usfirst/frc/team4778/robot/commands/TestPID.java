package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import pid.PIDController;

/**
 *
 */
public class TestPID extends Command {

	double endtime = 0;
	double time = 0;
	boolean calib = true;
	private PIDController pid;

	public TestPID(boolean cal) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drivetrain);
		calib = cal;

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("-TestPID-init");
		RobotMap.dir = true;
		pid = new PIDController(0.05, 0.05, 0.02, 0);
		// Robot.drivetrain.resetGyro();
		if (calib) {
			RobotMap.gyro.reset();
			// Robot.drivetrain.getPIDController().setPID(0.05, 0.03, 0.2);
		} else {
			pid.setOutputLimits(-1, 1);
		}
		// Robot.drivetrain.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println("-TestPID-exe");
		double output = pid.computePID(RobotMap.gyro.getAngle());
		if (!calib) {
			Robot.drivetrain.arcadeDrive(-0.85, output);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println("-TestPID-end");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
