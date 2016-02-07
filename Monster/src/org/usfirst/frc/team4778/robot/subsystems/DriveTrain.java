package org.usfirst.frc.team4778.robot.subsystems;

import org.usfirst.frc.team4778.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.hal.AccelerometerJNI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends PIDSubsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private static Victor left1 = new Victor(0);
	private static Victor left2 = new Victor(1);
	private static Victor right1 = new Victor(2);
	private static Victor right2 = new Victor(3);
	public static RobotDrive Drive = new RobotDrive(left2, left1, right2, right1);
	private AnalogGyro gyro = new AnalogGyro(0);
	private double speed = 0;
	double endtime = 0;
	double time = 0;

	public DriveTrain() {
		super(0.0, 0.0, 0.0);
		gyro.reset();
		getPIDController().setSetpoint(0.0);
		getPIDController().setOutputRange(-1, 1);
		getPIDController().setAbsoluteTolerance(1);
		getPIDController().disable();
		Drive.setInvertedMotor(MotorType.kFrontLeft, true);
		Drive.setInvertedMotor(MotorType.kRearLeft, true);
		Drive.setInvertedMotor(MotorType.kFrontRight, true);
		Drive.setInvertedMotor(MotorType.kRearRight, true);
	}

	public void resetGyro() {
		gyro.reset();
	}

	public void setSpeed(double in) {
		speed = in;
	}

	@Override
	protected double returnPIDInput() {
		return gyro.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		SmartDashboard.putNumber("Gyro:", gyro.getAngle());
		SmartDashboard.putNumber("AccelerometerZ:", AccelerometerJNI.getAccelerometerZ());
		SmartDashboard.putNumber("AccelerometerY:", AccelerometerJNI.getAccelerometerY());
		SmartDashboard.putNumber("AccelerometerX:", AccelerometerJNI.getAccelerometerX());
		if (speed != 0) {
			Drive.arcadeDrive(speed, output);
		} else {
			Drive.tankDrive(-output, output);
		}

	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new TankDrive());
	}

	public void tankDrive(Joystick joy1, Joystick joy2) {
		Drive.tankDrive(joy1, joy2);
	}

	public void tankDrive(double left, double right) {
		Drive.tankDrive(left, right);
	}

	public void arcadeDrive(Joystick stick) {
		Drive.arcadeDrive(stick);
	}

	public void arcadeDrive(double f, double s) {
		Drive.arcadeDrive(f, s);
	}

	public void stop(double stopingPower) {
		System.out.println("-stop");
		Drive.tankDrive(stopingPower, stopingPower);
		endtime = Timer.getFPGATimestamp() + 2;
		while (time < endtime) {
			time = Timer.getFPGATimestamp();
		}
		Drive.tankDrive(0, 0);
	}
}
