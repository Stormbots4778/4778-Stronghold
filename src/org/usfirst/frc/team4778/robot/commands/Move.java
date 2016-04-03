package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.pid.PIDController;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Move extends Command {

	private PIDController tpid;
	private PIDController rpid;
	double p, i, d, power;

	boolean isFinished = false;

	double distance = 0;
	double endTime = 0;

	public Move(double distance) {
		requires(Robot.drivetrain);
		this.distance = distance;
	}

	protected void initialize() {
		System.out.println("-init Move");

		RobotMap.leftdrive.setDistancePerPulse(0.125488281);
		RobotMap.rightdrive.setDistancePerPulse(0.125488281);
		RobotMap.rightdrive.reset();
		RobotMap.leftdrive.reset();
//		SmartDashboard.putNumber("p", p);
//		SmartDashboard.putNumber("i", i);
//		SmartDashboard.putNumber("d", d);

		RobotMap.direction = 1;

		tpid = new PIDController(0.125, 0, 0, RobotMap.h);
		tpid.setTolerence(1);
		tpid.setOutputLimits(-1, 1);

		rpid = new PIDController(0.05, 0, 0, distance);
		rpid.setTolerence(1);
		rpid.setOutputLimits(-0.85, 0.85);

		System.out.println("-end-init Move");
	}

	protected void execute() {
		System.out.println("-exe Move");

		double tout = tpid.computePID(RobotMap.ahrs.getYaw());
		double rout = rpid.computePID(RobotMap.leftdrive.getDistance());
		Robot.drivetrain.arcadeDrive(-rout, tout);
		if (rpid.onTarget()) {
			isFinished = true;
		}

//		p = SmartDashboard.getNumber("p");
//		i = SmartDashboard.getNumber("i");
//		d = SmartDashboard.getNumber("d");
//		// rpid.setTunings(p, i, d);
//		SmartDashboard.putNumber("p", p);
//		SmartDashboard.putNumber("i", i);
//		SmartDashboard.putNumber("d", d);

		System.out.println("-end-exe Move");
	}

	protected void end() {
		Robot.drivetrain.stop();

		System.out.println("-end Move");
	}

	protected void interrupted() {
		end();
	}

	protected boolean isFinished() {
		return isFinished;
	}
}
