package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 */
public class TurnToAngle extends PIDCommand {

	private boolean finished = false;
	private double angle;
	// private PIDController pid;

	public TurnToAngle(double ang) {
		super("pid", 0.05, 0.03, 0.2);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drivetrain);
		angle = ang;
		// pid = new PIDController(0.05, 0.03, 0.2, 90);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("-turn-init");
		// pid.setTolerence(1);
		// pid.setOutputLimits(-1, 1);
		this.getPIDController().setSetpoint(angle);
		this.getPIDController().setAbsoluteTolerance(1);
		this.getPIDController().setOutputRange(-1, 1);
		this.getPIDController().disable();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println("-turn-exe");
		// double out = pid.computePID(RobotMap.gyro.getAngle());
		// SmartDashboard.putNumber("PID output: ", out);
		// Robot.drivetrain.tankDrive(-out, out);
		this.getPIDController().enable();
		if (this.getPIDController().onTarget()) {
			finished = true;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return finished;
	}

	// Called once after isFinished returns true
	protected void end() {
		this.getPIDController().disable();
		System.out.println("-turn-end");
		RobotMap.h = angle;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return RobotMap.gyro.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		Robot.drivetrain.tankDrive(-output, output);

	}
}
