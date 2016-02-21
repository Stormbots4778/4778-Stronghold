package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import conversions.AccToAngle;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import pid.PIDController;

/**
 *
 */
public class BreachSecret extends Command {

	private PIDController pid;
	int angleThreshold = 10;
	boolean isFinished = false;
	boolean hasDrivenOnRamp = false;
	boolean goingForwards;
	double endtime = 0;
	double time = 0;
	
    public BreachSecret(boolean goingForwards, double time) {
    	requires(Robot.drivetrain);
		this.goingForwards = goingForwards;
		this.time = time;
    }

    protected void initialize() {
    	System.out.println("-breach-secret-init");
		RobotMap.gyro.reset();
		pid = new PIDController(0.05, 0.03, 0.2, 0);
		pid.setOutputLimits(-1, 1);
		pid.setOnTargetOffset(5);
		endtime = Timer.getFPGATimestamp() + time;
    }
    
    protected void execute() {
    	System.out.println("-breach-secret-exe");
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
		System.out.println("-breach-secret-end");
		if (goingForwards) {
			Robot.drivetrain.stop(0.2);
		} else {
			Robot.drivetrain.stop(-0.2);
		}
    }

    protected void interrupted() {
    	
    }
}
