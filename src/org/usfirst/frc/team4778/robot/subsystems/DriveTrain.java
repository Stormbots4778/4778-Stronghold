package org.usfirst.frc.team4778.robot.subsystems;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class DriveTrain extends PIDSubsystem {

	private static Victor left1 = new Victor(0);
	private static Victor left2 = new Victor(1);
	private static Victor left3 = new Victor(2);

	private static Victor right1 = new Victor(3);
	private static Victor right2 = new Victor(4);
	private static Victor right3 = new Victor(5);
	
	// Comp Bot:
//	private static VictorSP left1 = new VictorSP(0);
//	private static VictorSP left2 = new VictorSP(1);
//	private static VictorSP left3 = new VictorSP(2);
//
//	private static VictorSP right1 = new VictorSP(3);
//	private static VictorSP right2 = new VictorSP(4);
//	private static VictorSP right3 = new VictorSP(5);

	public static RobotDrive Drive1 = new RobotDrive(left1, right1);
	public static RobotDrive Drive2 = new RobotDrive(left2, right2);
	public static RobotDrive Drive3 = new RobotDrive(left3, right3);

	double endtime = 0;
	double time = 0;
	double input = 0;

	public DriveTrain() {
		super("pid", 0.05, 0, 0);
		dir();
		left1.setSafetyEnabled(false);
		left2.setSafetyEnabled(false);
		left3.setSafetyEnabled(false);
		right1.setSafetyEnabled(false);
		right2.setSafetyEnabled(false);
		right3.setSafetyEnabled(false);
	}

	private void dir() {
		System.out.println("#exe DriveTrain dir");

		left1.setInverted(true); // TODO Comp bot is false - Test bot is true
		right1.setInverted(true); // false
		left2.setInverted(true);
		right2.setInverted(true);
		left3.setInverted(true);
		right3.setInverted(true);

		System.out.println("#end-exe DriveTrain dir()");
	}

	public void initDefaultCommand() {
		setDefaultCommand(new TankDrive());
	}

	public void tankDrive(Joystick joy1, Joystick joy2) {
		System.out.println("#exe DriveTrain tankDrive(joy1, joy2)");
		this.getPIDController().disable();
		dir();
		Drive1.tankDrive(joy1, joy2);
		Drive2.tankDrive(joy1, joy2);
		Drive3.tankDrive(joy1, joy2);

		System.out.println("#end-exe DriveTrain tankDrive(joy1, joy2)");
	}

	public void tankDrive(double left, double right) {
		System.out.println("#exe DriveTrain tankDrive(left, right)");
		this.getPIDController().disable();
		dir();
		Drive1.tankDrive(left, right);
		Drive2.tankDrive(left, right);
		Drive3.tankDrive(left, right);

		System.out.println("#end-exe DriveTrain tankDrive(left, right)");
	}

	public void arcadeDrive(Joystick stick) {
		System.out.println("#exe DriveTrain arcadeDrive(stick)");
		this.getPIDController().disable();
		dir();
		Drive1.arcadeDrive(stick);
		Drive2.arcadeDrive(stick);
		Drive3.arcadeDrive(stick);

		System.out.println("#end-exe DriveTrain arcadeDrive(stick)");
	}

	public void arcadeDrive(Joystick stick1, Joystick stick2) {
		System.out.println("#exe DriveTrain arcadeDrive(stick1, stick2)");
		this.getPIDController().disable();
		dir();
		Drive1.arcadeDrive(stick1, 1, stick2, 0);
		Drive2.arcadeDrive(stick1, 1, stick2, 0);
		Drive3.arcadeDrive(stick1, 1, stick2, 0);

		System.out.println("#end-exe DriveTrain arcadeDrive(stick1,stick2)");
	}

	public void arcadeDrive(double f, double s) {
		System.out.println("#exe DriveTrain arcadeDrive(f, s)");
		this.getPIDController().disable();
		dir();
		Drive1.arcadeDrive(f, s);
		Drive2.arcadeDrive(f, s);
		Drive3.arcadeDrive(f, s);

		System.out.println("#end-exe DriveTrain arcadeDrive(f, s)");
	}

	public void stop() {
		System.out.println("#exe DriveTrain stop()");

		// this.getPIDController().setOutputRange(-1, 1);
		// this.getPIDController().setSetpoint(RobotMap.leftdrive.getDistance());
		// this.getPIDController().enable();

		Robot.drivetrain.arcadeDrive(0.8, RobotMap.encoder.getRate());

		System.out.println("#end-exe DriveTrain stop()");
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return RobotMap.encoder.getDistance();
	}

	@Override
	protected void usePIDOutput(double output) {
		Drive1.tankDrive(output, output);
		Drive2.tankDrive(output, output);
		Drive3.tankDrive(output, output);

	}
}
