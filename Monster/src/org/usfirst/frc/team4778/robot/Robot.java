package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.AutoCheval1;
import org.usfirst.frc.team4778.robot.commands.AutoCheval2;
import org.usfirst.frc.team4778.robot.commands.AutoCheval3;
import org.usfirst.frc.team4778.robot.commands.AutoCheval4;
import org.usfirst.frc.team4778.robot.commands.AutoDrive1;
import org.usfirst.frc.team4778.robot.commands.AutoDrive2;
import org.usfirst.frc.team4778.robot.commands.AutoDrive3;
import org.usfirst.frc.team4778.robot.commands.AutoDrive4;
import org.usfirst.frc.team4778.robot.commands.AutoLow;
import org.usfirst.frc.team4778.robot.commands.AutoPortical1;
import org.usfirst.frc.team4778.robot.commands.AutoPortical2;
import org.usfirst.frc.team4778.robot.commands.AutoPortical3;
import org.usfirst.frc.team4778.robot.commands.AutoPortical4;
import org.usfirst.frc.team4778.robot.commands.NoAuto;
import org.usfirst.frc.team4778.robot.commands.TankDrive;
import org.usfirst.frc.team4778.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4778.robot.subsystems.Intake;
import org.usfirst.frc.team4778.robot.subsystems.ManipulatorLift;
import org.usfirst.frc.team4778.robot.subsystems.Shifters;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	public static OI oi;
	public static TankDrive tankdrive;
	public static DriveTrain drivetrain;
	public static Shifters shift;
	public static ManipulatorLift ball;
	public static Intake in;
	// NIVision.Rect rect = new NIVision.Rect(10, 10, 200, 200);

	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		System.out.println("init");
		RobotMap.gy2.reset();
		RobotMap.gyro.reset();
		RobotMap.h = RobotMap.gyro.getAngle();
		RobotMap.f = RobotMap.gy2.getAngle();
		drivetrain = new DriveTrain();
		shift = new Shifters();
		ball = new ManipulatorLift();
		in = new Intake();
		oi = new OI();
		RobotMap.camserver.startAutomaticCapture("cam0");
		RobotMap.auto.addDefault("lowBar", new AutoLow());
		RobotMap.auto.addObject("driving defence | low | * | 0 | 0 | 0 | ", new AutoDrive1());
		RobotMap.auto.addObject("driving defence | low | 0 | * | 0 | 0 | ", new AutoDrive2());
		RobotMap.auto.addObject("driving defence | low | 0 | 0 | * | 0 | ", new AutoDrive3());
		RobotMap.auto.addObject("driving defence | low | 0 | 0 | 0 | * | ", new AutoDrive4());
		RobotMap.auto.addObject("cheval | low | * | 0 | 0 | 0 | ", new AutoCheval1());
		RobotMap.auto.addObject("cheval | low | 0 | * | 0 | 0 | ", new AutoCheval2());
		RobotMap.auto.addObject("cheval | low | 0 | 0 | * | 0 | ", new AutoCheval3());
		RobotMap.auto.addObject("cheval | low | 0 | 0 | 0 | * | ", new AutoCheval4());
		RobotMap.auto.addObject("portical | low | * | 0 | 0 | 0 | ", new AutoPortical1());
		RobotMap.auto.addObject("portical | low | 0 | * | 0 | 0 | ", new AutoPortical2());
		RobotMap.auto.addObject("portical | low | 0 | 0 | * | 0 | ", new AutoPortical3());
		RobotMap.auto.addObject("portical | low | 0 | 0 | 0 | * | ", new AutoPortical4());
		RobotMap.auto.addObject("no auto", new NoAuto());
	}

	public void smartdash() {
		SmartDashboard.putData("Auto Chooser", RobotMap.auto);
		SmartDashboard.putNumber("yaw gyro:", RobotMap.gyro.getAngle());
		SmartDashboard.putNumber("pitch gyro:", RobotMap.gy2.getAngle());
		SmartDashboard.putNumber("heading", RobotMap.h);
		SmartDashboard.putNumber("flat value", RobotMap.f);
		SmartDashboard.putNumber("accX", RobotMap.acc.getX());
		SmartDashboard.putNumber("accY", RobotMap.acc.getY());
		SmartDashboard.putNumber("accZ", RobotMap.acc.getZ());
		SmartDashboard.putNumber("left encoder", RobotMap.leftdrive.getDistance());
		SmartDashboard.putNumber("right encoder", RobotMap.rightdrive.getDistance());
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit() {
		System.out.println("disabled");
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		smartdash();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	public void autonomousInit() {
		RobotMap.gy2.reset();
		RobotMap.gyro.reset();
		System.out.println("autoInit");
		// schedule the autonomous command (example)
		autonomousCommand = (Command) RobotMap.auto.getSelected();
		// autonomousCommand = new AutoDrive1();
		// autonomousCommand = new Breach(-0.8);
		// autonomousCommand = new Move(36);
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		System.out.println("auto");
		Scheduler.getInstance().run();
		smartdash();
	}

	public void teleopInit() {
		System.out.println("teleopInit");
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		System.out.println("teleop");
		Scheduler.getInstance().run();
		smartdash();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		System.out.println("test");
		LiveWindow.run();
		smartdash();
	}
}
