package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.SensorReset;
import org.usfirst.frc.team4778.robot.commands.TankDrive;
import org.usfirst.frc.team4778.robot.commands.autonomous.AutoCheval;
import org.usfirst.frc.team4778.robot.commands.autonomous.AutoGeneral;
import org.usfirst.frc.team4778.robot.commands.autonomous.AutoLow;
import org.usfirst.frc.team4778.robot.commands.autonomous.AutoNone;
import org.usfirst.frc.team4778.robot.commands.autonomous.AutoPortcullis;
import org.usfirst.frc.team4778.robot.conversions.Pitch;
import org.usfirst.frc.team4778.robot.conversions.Slope;
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
	public static boolean score;

	Command autonomousCommand;

	public void robotInit() {
		System.out.println("init");
		RobotMap.gy2.calibrate();
		RobotMap.gyro.calibrate();
		RobotMap.h = RobotMap.gyro.getAngle();
		RobotMap.f = RobotMap.gy2.getAngle();
		drivetrain = new DriveTrain();
		shift = new Shifters();
		ball = new ManipulatorLift();
		in = new Intake();
		oi = new OI();
		smartdashInit();
		smartdash();

	}

	public void smartdashInit() {
		SmartDashboard.putBoolean("Score", score);
		RobotMap.auto.addDefault("Low Bar", new AutoLow(true));
		RobotMap.auto.addObject("Normal Defense  | * | 0 | 0 | 0 | ", new AutoGeneral(1, score));
		RobotMap.auto.addObject("Normal Defense  | 0 | * | 0 | 0 | ", new AutoGeneral(2, score));
		RobotMap.auto.addObject("Normal Defense  | 0 | 0 | * | 0 | ", new AutoGeneral(3, score));
		RobotMap.auto.addObject("Normal Defense  | 0 | 0 | 0 | * | ", new AutoGeneral(4, score));
		RobotMap.auto.addObject("Cheval De Frise | * | 0 | 0 | 0 | ", new AutoCheval(1, score));
		RobotMap.auto.addObject("Cheval De Frise | 0 | * | 0 | 0 | ", new AutoCheval(2, score));
		RobotMap.auto.addObject("Cheval De Frise | 0 | 0 | * | 0 | ", new AutoCheval(3, score));
		RobotMap.auto.addObject("Cheval De Frise | 0 | 0 | 0 | * | ", new AutoCheval(4, score));
		RobotMap.auto.addObject("Portcullis      | * | 0 | 0 | 0 | ", new AutoPortcullis(1, score));
		RobotMap.auto.addObject("Portcullis      | 0 | * | 0 | 0 | ", new AutoPortcullis(2, score));
		RobotMap.auto.addObject("Portcullis      | 0 | 0 | * | 0 | ", new AutoPortcullis(3, score));
		RobotMap.auto.addObject("Portcullis      | 0 | 0 | 0 | * | ", new AutoPortcullis(4, score));
		RobotMap.auto.addObject("No Autonomous", new AutoNone());
		SmartDashboard.putData("Reset Sensors", new SensorReset());
	}

	public void smartdash() {
		Pitch p = new Pitch(RobotMap.acc);
		Slope s = new Slope(RobotMap.acc);
		SmartDashboard.putData("Auto Chooser", RobotMap.auto);
		SmartDashboard.putNumber("Yaw gyro: ", RobotMap.gyro.getAngle());
		SmartDashboard.putNumber("Pitch gyro: ", RobotMap.gy2.getAngle());
		SmartDashboard.putNumber("Heading ", RobotMap.h);
		SmartDashboard.putNumber("AccPitch", Math.floor(p.getP()));
		SmartDashboard.putNumber("Encoder L: ", RobotMap.leftdrive.getDistance());
		SmartDashboard.putNumber("Encoder R: ", RobotMap.rightdrive.getDistance());
		score = SmartDashboard.getBoolean("Score");
		SmartDashboard.putBoolean("Score", score);
		SmartDashboard.putNumber("Slope", s.getSlope());
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
		System.out.println("autoInit");
		// autonomousCommand = new Breach(-0.8);
		autonomousCommand = (Command) RobotMap.auto.getSelected();
		// autonomousCommand = new TurnToAngle(90);
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
