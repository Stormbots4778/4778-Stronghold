package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.utils.conversions.AccToAngle;
import org.usfirst.frc.team4778.utils.pid.PIDController;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class BreachLow extends Command {

	private PIDController pid;
	boolean isFinished = false;
	boolean hasLeveledOutOnce = false;
	boolean startedGoingDown = false;
	boolean goingForwards;
	double endTime = 0;
	double time = 0;
	
    public BreachLow(boolean goingForwards, double time) {
    	requires(Robot.drivetrain);
		this.goingForwards = goingForwards;
		this.time = time;
    }

    protected void initialize() {
    	System.out.println("-breach-low-init");
		RobotMap.gyro.reset();
		pid = new PIDController(0.05, 0.03, 0.2, 0);
		pid.setOutputLimits(-1, 1);
		pid.setOnTargetOffset(5);
		endTime = Timer.getFPGATimestamp() + time;
    }
    
    protected void execute() {
    	System.out.println("-breach-low-exe");
		double output = pid.computePID(RobotMap.gyro.getAngle());
		double angle = AccToAngle.getXRotation(RobotMap.acc);
		time = Timer.getFPGATimestamp();
		if (time > endTime) {
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
			
			if (hasLeveledOutOnce) {
				if (angle > 2) {
					startedGoingDown = true;
				}
			} else if (startedGoingDown) {
				if (angle < 2) {
					isFinished = true;
				}
			} else {
				if (time > endTime - 2.5 && angle < 2) {
					hasLeveledOutOnce = true;
				}
			}
		}
    }

    protected boolean isFinished() {
		return isFinished;
    }

    protected void end() {
		System.out.println("-breach-low-end");
		if (goingForwards) {
			Robot.drivetrain.stop(0.2);
		} else {
			Robot.drivetrain.stop(-0.2);
		}
    }

    protected void interrupted() {
    	
    }
}
