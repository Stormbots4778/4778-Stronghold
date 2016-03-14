package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.Autonomous;
import org.usfirst.frc.team4778.robot.commands.SelectDefence;
import org.usfirst.frc.team4778.robot.commands.SelectPos;
import org.usfirst.frc.team4778.robot.commands.TankDrive;
import org.usfirst.frc.team4778.robot.subsystems.BallControl;
import org.usfirst.frc.team4778.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4778.robot.subsystems.Lifter;
import org.usfirst.frc.team4778.robot.subsystems.Shifters;

import conversions.AccToAngle;
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
	public static BallControl ball;
	public static Lifter lift;
	// NIVision.Rect rect = new NIVision.Rect(10, 10, 200, 200);

	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		System.out.println("init");
		drivetrain = new DriveTrain();
		shift = new Shifters();
		ball = new BallControl();
		lift = new Lifter();
		oi = new OI();
		RobotMap.gyro.reset();
		RobotMap.camserver.startAutomaticCapture("cam1");
		RobotMap.auto.addDefault("lowBar", new SelectDefence(0));
		RobotMap.auto.addObject("driving defence", new SelectDefence(1));
		RobotMap.auto.addObject("cheval", new SelectDefence(2));
		RobotMap.auto.addObject("portical", new SelectDefence(3));
		RobotMap.auto.addObject("no auto", new SelectDefence(4));
		RobotMap.autopos.addDefault("| low | * | 0 | 0 | 0 |", new SelectPos(0));
		RobotMap.autopos.addObject("| low | 0 | * | 0 | 0 |", new SelectPos(1));
		RobotMap.autopos.addObject("| low | 0 | 0 | * | 0 |", new SelectPos(2));
		RobotMap.autopos.addObject("| low | 0 | 0 | 0 | * |", new SelectPos(3));
	}

	public void smartdash() {
		AccToAngle aa = new AccToAngle(RobotMap.acc);
		SmartDashboard.putData("Auto Defence Chooser", RobotMap.auto);
		SmartDashboard.putData("Auto Location Chooser", RobotMap.autopos);
		SmartDashboard.putNumber("gyro:", RobotMap.gyro.getAngle());
		SmartDashboard.putNumber("pitch:", aa.getYRotation());
		SmartDashboard.putNumber("roll:", aa.getXRotation());
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit() {
		System.out.println("disabledInit");
	}

	public void disabledPeriodic() {
		System.out.println("disabled");
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
		System.out.println("autoInit");
		// schedule the autonomous command (example)
		autonomousCommand = new Autonomous(RobotMap.def, RobotMap.pos);
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
