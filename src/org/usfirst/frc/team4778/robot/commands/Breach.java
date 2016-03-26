package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import pid.PIDController;

<<<<<<< HEAD
public class Breach extends PIDCommand {
	boolean isFinished = false;
=======
/**
 *
 */
public class Breach extends Command {
	boolean finished = false;
>>>>>>> origin/pid
	double power = 0;
	boolean active = false;
	private PIDController pid;

	public Breach(double pow) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drivetrain);
		power = pow;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("-breach-init");
		RobotMap.gy2.reset();
		RobotMap.dir = true;
		pid = new PIDController(0.05, 0.04, 0.2, RobotMap.h);
		pid.setOutputLimits(-1, 1);
		pid.setTolerence(1);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println("-breach-exe");
		double output = pid.computePID(RobotMap.gyro.getAngle());
		double angle = RobotMap.gy2.getAngle();
		double anglel = RobotMap.f - 5;
		double angleh = RobotMap.f + 5;
		Robot.drivetrain.arcadeDrive(power, output);
		if (active) {
			if (angle < -20) {
				isFinished = true;
			}
		} else {
			if (angle < anglel ^ angle > angleh) {
				active = true;
			}
		}
	}

	protected boolean isFinished() {
		return isFinished;
	}

	protected void end() {
		System.out.println("-breach-end");
<<<<<<< HEAD
		this.getPIDController().disable();
=======
		// Robot.drivetrain.stop();
>>>>>>> origin/pid
		Robot.drivetrain.arcadeDrive(0, 0);
		RobotMap.gy2.reset();
	}

	protected void interrupted() {
		end();
	}
<<<<<<< HEAD

	@Override
	protected double returnPIDInput() {
		return RobotMap.gyro.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		Robot.drivetrain.arcadeDrive(power, output);
	}
=======
>>>>>>> origin/pid
}
