package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.pid.PIDController;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Delay extends Command {

	double endtime, time;
	boolean finish = false;

	PIDController pid;

	public Delay(double val) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		time = val / 1000;
		requires(Robot.drivetrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		endtime = Timer.getFPGATimestamp() + time;
		RobotMap.leftdrive.setDistancePerPulse(0.125488281);
		RobotMap.rightdrive.setDistancePerPulse(0.125488281);
		RobotMap.rightdrive.reset();
		RobotMap.leftdrive.reset();
		pid = new PIDController(0.05, 0, 0, 0);
		pid.setTolerence(1);
		pid.setOutputLimits(-0.85, 0.85);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double out = pid.computePID(RobotMap.leftdrive.getDistance());
		Robot.drivetrain.tankDrive(out, out);
		if (Timer.getFPGATimestamp() > endtime) {
			finish = true;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return finish;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drivetrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
