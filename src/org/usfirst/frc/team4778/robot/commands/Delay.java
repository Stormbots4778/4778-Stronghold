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
		time = val / 1000;
		requires(Robot.drivetrain);
	}

	protected void initialize() {
		System.out.println("-init Delay");
		
		endtime = Timer.getFPGATimestamp() + time;
		RobotMap.leftdrive.setDistancePerPulse(0.125488281);
		RobotMap.rightdrive.setDistancePerPulse(0.125488281);
		RobotMap.rightdrive.reset();
		RobotMap.leftdrive.reset();
		pid = new PIDController(0.05, 0, 0, 0);
		pid.setTolerence(1);
		pid.setOutputLimits(-0.85, 0.85);
		
		System.out.println("-end-init Delay");
	}
	
	protected void execute() {
		System.out.println("-exe Delay");
		
		double out = pid.computePID(RobotMap.leftdrive.getDistance());
		Robot.drivetrain.tankDrive(out, out);
		if (Timer.getFPGATimestamp() > endtime) {
			finish = true;
		}
		
		System.out.println("-end-exe Delay");
	}

	protected boolean isFinished() {
		return finish;
	}

	protected void end() {
		Robot.drivetrain.stop();
	}

	protected void interrupted() {
		end();
	}
}
