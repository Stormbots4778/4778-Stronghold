package org.usfirst.frc.team4778.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

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

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void resetGyro() {
		gyro.reset();
	}

	public void TankDrive(Joystick left, Joystick right) {
		Drive.tankDrive(left, right);
	}

	public void setSpeed(double in) {
		speed = in;
	}

	public void Stop() {
		if (left1.getSpeed() > 0) {
			left1.set(-0.5);
		}
		if (left1.getSpeed() < 0) {
			left1.set(0.5);
		}
		if (left2.getSpeed() > 0) {
			left2.set(-0.5);
		}
		if (left2.getSpeed() < 0) {
			left2.set(0.5);
		}
		if (right1.getSpeed() > 0) {
			right1.set(-0.5);
		}
		if (right1.getSpeed() < 0) {
			right1.set(0.5);
		}
		if (right2.getSpeed() > 0) {
			right2.set(-0.5);
		}
		if (right2.getSpeed() < 0) {
			right2.set(0.5);
		}
		Timer.delay(1000);
		speed = 0;
		Drive.tankDrive(0.0, 0.0);
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return gyro.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		if (speed == 0) {
			Drive.tankDrive(output, -output);
		} else {
			Drive.arcadeDrive(speed, output);
		}
	}
}
