package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import pid.PIDController;

/**
 *
 */
public class Move extends Command {

	boolean finished = false;
	double dist = 0;
	double endTime = 0;

	private PIDController tpid;
	private PIDController rpid;
	// private PIDController lpid;

	public Move(double dis) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drivetrain);
		dist = dis;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("-move-Int");
		RobotMap.dir = true;
		// inches = 0.125488281
		RobotMap.leftdrive.setDistancePerPulse(0.125488281);
		RobotMap.rightdrive.setDistancePerPulse(0.125488281);
		RobotMap.rightdrive.reset();
		RobotMap.leftdrive.reset();
		tpid = new PIDController(0.05, 0.03, 0.2, RobotMap.h);
		tpid.setTolerence(1);
		tpid.setOutputLimits(-1, 1);
		// lpid = new PIDController(0.05, 0.03, 0.2, dist);
		// lpid.setTolerence(1);
		// lpid.setOutputLimits(-1, 1);
		rpid = new PIDController(0.05, 0.08, 0, dist);
		rpid.setTolerence(0.5);
		rpid.setOutputLimits(-1, 1);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println("-move-exe");
		double tout = tpid.computePID(RobotMap.gyro.getAngle());
		// double lout = lpid.computePID(RobotMap.leftdrive.getDistance());
		double rout = rpid.computePID(RobotMap.leftdrive.getDistance());
		Robot.drivetrain.arcadeDrive(-rout, tout);
		if (rpid.onTarget()) {
			finished = true;
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return finished;
	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println("-move-end");
		Robot.drivetrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
