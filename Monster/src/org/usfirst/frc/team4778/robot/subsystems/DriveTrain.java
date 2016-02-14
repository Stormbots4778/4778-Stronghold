package org.usfirst.frc.team4778.robot.subsystems;

import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class DriveTrain extends PIDSubsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private static VictorSP left1 = new VictorSP(0);
	private static VictorSP left2 = new VictorSP(1);
	private static VictorSP left3 = new VictorSP(2);
	private static VictorSP right1 = new VictorSP(3);
	private static VictorSP right2 = new VictorSP(4);
	private static VictorSP right3 = new VictorSP(5);
	public static RobotDrive Drive1 = new RobotDrive(left1, right1);
	public static RobotDrive Drive2 = new RobotDrive(left2, right2);
	public static RobotDrive Drive3 = new RobotDrive(left3, right3);
	private double speed = 0;
	double endtime = 0;
	double time = 0;
	double input = 0;

	public DriveTrain() {
		super(0.0, 0.0, 0.0);
		RobotMap.gyro.reset();
		getPIDController().setSetpoint(0.0);
		getPIDController().setOutputRange(-1, 1);
		getPIDController().setAbsoluteTolerance(1);
		getPIDController().disable();
	}

	public void resetGyro() {
		RobotMap.gyro.reset();
	}

	public double getGyro() {
		return RobotMap.gyro.getAngle();
	}

	public void setSpeed(double in) {
		speed = in;
	}

	public void setInput(double value) {
		input = value;
	}

	@Override
	protected double returnPIDInput() {
		return input;
	}

	@Override
	protected void usePIDOutput(double output) {
		if (speed != 0) {
			Drive1.arcadeDrive(speed, output);
			Drive2.arcadeDrive(speed, output);
			Drive3.arcadeDrive(speed, output);
		} else {
			Drive1.tankDrive(-output, output);
			Drive2.tankDrive(-output, output);
			Drive3.tankDrive(-output, output);
		}

	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new TankDrive());
	}

	public void tankDrive(Joystick joy1, Joystick joy2) {
		Drive1.tankDrive(joy1, joy2);
		Drive2.tankDrive(joy1, joy2);
		Drive3.tankDrive(joy1, joy2);
	}

	public void tankDrive(double left, double right) {
		Drive1.tankDrive(left, right);
		Drive2.tankDrive(left, right);
		Drive3.tankDrive(left, right);
	}

	public void arcadeDrive(Joystick stick) {
		Drive1.arcadeDrive(stick);
		Drive2.arcadeDrive(stick);
		Drive3.arcadeDrive(stick);
	}

	public void arcadeDrive(double f, double s) {
		Drive1.arcadeDrive(f, s);
		Drive2.arcadeDrive(f, s);
		Drive3.arcadeDrive(f, s);
	}

	public void stop(double stopingPower) {
		System.out.println("-stop");
		Drive1.tankDrive(stopingPower, stopingPower);
		Drive2.tankDrive(stopingPower, stopingPower);
		Drive3.tankDrive(stopingPower, stopingPower);
		endtime = Timer.getFPGATimestamp() + 1;
		while (time < endtime) {
			time = Timer.getFPGATimestamp();
		}
		Drive1.tankDrive(0, 0);
		Drive2.tankDrive(0, 0);
		Drive3.tankDrive(0, 0);
	}
}
