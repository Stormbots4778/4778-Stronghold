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
	double p, i, d;

	public TurnToAngle(double ang) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drivetrain);
		angle = ang;
		pid = new PIDController(0.125, 0.0, 0.0, angle);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("-turn-init");
		pid.setTolerence(1);
		pid.setOutputLimits(-1, 1);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println("-turn-exe");
		double out = pid.computePID(RobotMap.gyro.getAngle());
		Robot.drivetrain.tankDrive(-out, out);
		if (pid.onTarget()) {
			finished = true;
		}
		// p = SmartDashboard.getNumber("p");
		// i = SmartDashboard.getNumber("i");
		// d = SmartDashboard.getNumber("d");
		// pid.setTunings(p, i, d);
		// SmartDashboard.putNumber("p", p);
		// SmartDashboard.putNumber("i", i);
		// SmartDashboard.putNumber("d", d);

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return finished;
	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println("-turn-end");
		RobotMap.h = angle;
		Robot.drivetrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
