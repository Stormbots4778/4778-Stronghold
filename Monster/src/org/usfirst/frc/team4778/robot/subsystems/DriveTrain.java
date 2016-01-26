package org.usfirst.frc.team4778.robot.subsystems;

import org.usfirst.frc.team4778.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	// public static Talon leftMotor = new Talon(0);
	// public static Talon rightMotor = new Talon(1);
	private static Victor left1 = new Victor(0);
	private static Victor left2 = new Victor(1);
	private static Victor right1 = new Victor(2);
	private static Victor right2 = new Victor(3);
	public static RobotDrive Drive = new RobotDrive(left2, left1, right2, right1);

	public DriveTrain() {
		Drive.setInvertedMotor(MotorType.kFrontLeft, true);
		Drive.setInvertedMotor(MotorType.kRearLeft, true);
		Drive.setInvertedMotor(MotorType.kFrontRight, true);
		Drive.setInvertedMotor(MotorType.kRearRight, true);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new TankDrive());
	}

	public void TankDrive(Joystick left, Joystick right) {
		Drive.tankDrive(left, right);
	}

	public void stop() {
		Drive.tankDrive(0.0, 0.0);
	}
}
