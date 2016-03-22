package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import pid.PIDController;

/**
 *
 */
public class TurnToAngle extends Command {

	private boolean finished = false;
	private double angle;
	private PIDController pid;

	public TurnToAngle(double ang) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drivetrain);
		RobotMap.h = ang;
		pid = new PIDController(0.05, 0.03, 0.2, RobotMap.h);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("-turn-init");
		RobotMap.dir = true;
		// Robot.drivetrain.resetGyro();
		// Robot.drivetrain.setSpeed(0);
		// Robot.drivetrain.setSetpoint(angle);
		// Robot.drivetrain.getPIDController().setPID(0.05, 0.03, 0.2);
		// Robot.drivetrain.setOutputRange(-1, 1);
		// Robot.drivetrain.setAbsoluteTolerance(1);
		// Robot.drivetrain.enable();
		pid.setTolerence(1);
		pid.setOutputLimits(-1, 1);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println("-turn-exe");
		// Robot.drivetrain.setInput(RobotMap.gyro.getAngle());
		double out = pid.computePID(RobotMap.gyro.getAngle());
		Robot.drivetrain.tankDrive(-out, out);
		// if (Robot.drivetrain.onTarget()) {
		// finished = true;
		// }
		if (pid.onTarget()) {
			finished = true;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return finished;
	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println("-turn-end");
		// Robot.drivetrain.disable();
		RobotMap.h = angle;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
