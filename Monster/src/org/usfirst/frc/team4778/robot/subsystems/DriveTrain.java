package org.usfirst.frc.team4778.robot.subsystems;

import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import pid.PIDController;

/**
 *
 */
public class DriveTrain extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	// private static VictorSP left1 = new VictorSP(0);
	// private static VictorSP left2 = new VictorSP(1);
	// private static VictorSP left3 = new VictorSP(2);
	// private static VictorSP right1 = new VictorSP(3);
	// private static VictorSP right2 = new VictorSP(4);
	// private static VictorSP right3 = new VictorSP(5);
	private static Victor left1 = new Victor(0);
	private static Victor left2 = new Victor(1);
	private static Victor left3 = new Victor(2);
	private static Victor right1 = new Victor(3);
	private static Victor right2 = new Victor(4);
	private static Victor right3 = new Victor(5);
	public static RobotDrive Drive1 = new RobotDrive(left1, right1);
	public static RobotDrive Drive2 = new RobotDrive(left2, right2);
	public static RobotDrive Drive3 = new RobotDrive(left3, right3);
	double endtime = 0;
	double time = 0;
	double input = 0;

	public DriveTrain() {
		dir();
	}

	private void dir() {
		System.out.println("#drive-dir");
		left1.setInverted(true);
		right1.setInverted(true);
		left2.setInverted(true);
		right2.setInverted(true);
		left3.setInverted(true);
		right3.setInverted(true);
		/*
		 * if (RobotMap.dir) { left1.setInverted(false);
		 * right1.setInverted(false); left2.setInverted(true);
		 * right2.setInverted(true); left3.setInverted(true);
		 * right3.setInverted(true); } else { left1.setInverted(true);
		 * right1.setInverted(true); left2.setInverted(false);
		 * right2.setInverted(false); left3.setInverted(false);
		 * right3.setInverted(false); }
		 */
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new TankDrive());
	}

	public void tankDrive(Joystick joy1, Joystick joy2) {
		System.out.println("#drive-td");
		dir();
		if (RobotMap.dir) {
			Drive1.tankDrive(joy1, joy2);
			Drive2.tankDrive(joy1, joy2);
			Drive3.tankDrive(joy1, joy2);
		} else {
			Drive1.tankDrive(joy2, joy1);
			Drive2.tankDrive(joy2, joy1);
			Drive3.tankDrive(joy2, joy1);
		}
	}

	public void tankDrive(double left, double right) {
		System.out.println("#drive-td");
		dir();
		Drive1.tankDrive(left, right);
		Drive2.tankDrive(left, right);
		Drive3.tankDrive(left, right);
	}

	public void arcadeDrive(Joystick stick) {
		System.out.println("#drive-ad");
		dir();
		Drive1.arcadeDrive(stick);
		Drive2.arcadeDrive(stick);
		Drive3.arcadeDrive(stick);
	}

	public void arcadeDrive(double f, double s) {
		System.out.println("#drive-ad");
		dir();
		Drive1.arcadeDrive(f, s);
		Drive2.arcadeDrive(f, s);
		Drive3.arcadeDrive(f, s);
	}

	public void stop() {
		PIDController pid = new PIDController(0.05, 0.03, 0.2,
				(RobotMap.leftdrive.getDistance() + RobotMap.rightdrive.getDistance()) / 2);
		System.out.println("#drive-stop");
		System.out.println("-stop");
		while (!pid.onTarget()) {
			System.out.println("stopping");
			double pow = pid.computePID((RobotMap.leftdrive.getDistance() + RobotMap.rightdrive.getDistance()) / 2);
			Drive1.tankDrive(pow, pow);
			Drive2.tankDrive(pow, pow);
			Drive3.tankDrive(pow, pow);
		}
		Drive1.tankDrive(0, 0);
		Drive2.tankDrive(0, 0);
		Drive3.tankDrive(0, 0);
	}
}
