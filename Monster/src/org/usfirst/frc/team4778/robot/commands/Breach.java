package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.utils.conversions.AccToAngle;
import org.usfirst.frc.team4778.utils.pid.PIDController;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Breach extends Command {
	int angleThreshold = 10;
	
	double endtime = 0;
	double time = 0;
	double countDownTimer = 0;
	boolean countDownTimerHasStarted = false;
	boolean hasDrivenOnRamp = false;
	boolean goingForwards;
	boolean isFinished = false;

	private PIDController pid;

	public Breach(boolean goingForwards, double time) {
		requires(Robot.drivetrain);
		this.time = time;
		this.goingForwards = goingForwards;
	}

	protected void initialize() {
		System.out.println("-breach-init");
		
		RobotMap.dir = true;
		RobotMap.gyro.reset();
		
		pid = new PIDController(0.05, 0.03, 0.2, 0);
		pid.setOutputLimits(-1, 1);
		pid.setOnTargetOffset(5);
		
		endtime = Timer.getFPGATimestamp() + time;
	}

	protected void execute() {
		System.out.println("-breach-exe");
		
		double output = pid.computePID(RobotMap.gyro.getAngle());
		double angle = AccToAngle.getXRotation(RobotMap.acc);
		
		time = Timer.getFPGATimestamp();
		
		if (time > endtime) {
			if (pid.onTarget()) {
				isFinished = true;
			} else {
				Robot.drivetrain.tankDrive(-output, output);
			}
		} else {
			if (goingForwards) {
				Robot.drivetrain.arcadeDrive(-0.85, output);
			} else {
				Robot.drivetrain.arcadeDrive(0.85, output);
			}
			
			if (hasDrivenOnRamp) {
				if (angle < 2) {
					if (countDownTimerHasStarted) {
						if (time == countDownTimer) {
							isFinished = true;
						} else {
							countDownTimerHasStarted = false;
						}
					} else {
						countDownTimerHasStarted = true;
						countDownTimer = time + 0.5;
					}
				}
			} else {
				if (angle > angleThreshold) {
					hasDrivenOnRamp = true;
				}
			}
		}
	}

	protected boolean isFinished() {
		return isFinished;
	}

	protected void end() {
		System.out.println("-breach-end");
		if (goingForwards) {
			Robot.drivetrain.stop(0.2);
		} else {
			Robot.drivetrain.stop(-0.2);
		}

	}

	protected void interrupted() {
		end();
	}
}
