package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;
import pid.PIDController;

/**
 *
 */
public class Move extends PIDCommand {

	boolean finished = false;
	double dist = 0;
	double endTime = 0;
	double steering = 0;
	PIDController pid;

	// private PIDController tpid;
	// private PIDController rpid;
	// private PIDController lpid;

	public Move(double dis) {
		super("pid", 0.05, 0.03, 0.2);
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
		pid.setTunings(0.05, 0.03, 0.2);
		pid.setOutputLimits(-1, 1);
		pid.setSetpoint(RobotMap.h);
		// tpid = new PIDController(0.05, 0.03, 0.2, RobotMap.h);
		// tpid.setTolerence(1);
		// tpid.setOutputLimits(-1, 1);
		// lpid = new PIDController(0.05, 0.03, 0.2, dist);
		// lpid.setTolerence(1);
		// lpid.setOutputLimits(-1, 1);
		// rpid = new PIDController(0.05, 0.03, 0, dist);
		// rpid.setTolerence(1);
		// rpid.setOutputLimits(-1, 1);
		this.getPIDController()
				.setSetpoint(dist + (RobotMap.rightdrive.getDistance() + RobotMap.leftdrive.getDistance() / 2));
		this.getPIDController().setAbsoluteTolerance(1);
		this.getPIDController().setOutputRange(-1, 1);
		this.getPIDController().disable();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println("-move-exe");
		this.getPIDController().enable();
		// double tout = tpid.computePID(RobotMap.gyro.getAngle());
		// double lout = lpid.computePID(RobotMap.leftdrive.getDistance());
		// double rout = rpid.computePID(RobotMap.rightdrive.getDistance());
		// Robot.drivetrain.arcadeDrive(rout, tout);
		steering = pid.computePID(RobotMap.gyro.getAngle());
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
		System.out.println("-move-end");
		this.getPIDController().disable();
		Robot.drivetrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return RobotMap.rightdrive.getDistance() + RobotMap.leftdrive.getDistance() / 2;
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		Robot.drivetrain.arcadeDrive(output, steering);

	}
}
