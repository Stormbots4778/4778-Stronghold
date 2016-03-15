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
	private PIDController dpid;

	public Move(double dis) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drivetrain);
		double curr = (RobotMap.leftdrive.getDistance() + RobotMap.rightdrive.getDistance()) / 2;
		dist = curr + dis;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("-move-Int");
		RobotMap.dir = true;
		// inches = 0.125488281
		RobotMap.leftdrive.setDistancePerPulse(0.125488281);
		RobotMap.rightdrive.setDistancePerPulse(0.125488281);
		tpid = new PIDController(0.05, 0.03, 0.2, RobotMap.h);
		tpid.setOnTargetOffset(1);
		tpid.setOutputLimits(-1, 1);
		dpid = new PIDController(0.05, 0.03, 0.2, dist);
		dpid.setOnTargetOffset(1);
		dpid.setOutputLimits(-1, 1);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println("-move-exe");
		double tout = tpid.computePID(RobotMap.gyro.getAngle());
		double dout = dpid.computePID((RobotMap.leftdrive.getDistance() + RobotMap.rightdrive.getDistance()) / 2);
		Robot.drivetrain.arcadeDrive(dout, tout);
		if (dpid.onTarget()) {
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
