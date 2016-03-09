package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.Autonomous;
import org.usfirst.frc.team4778.robot.commands.TankDrive;
import org.usfirst.frc.team4778.robot.subsystems.BallControl;
import org.usfirst.frc.team4778.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4778.robot.subsystems.Gimbal;
import org.usfirst.frc.team4778.robot.subsystems.Lifter;
import org.usfirst.frc.team4778.robot.subsystems.Shifters;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {
	public static OI oi;
	public static TankDrive tankdrive;
	public static DriveTrain drivetrain;
	public static Gimbal gimbal;
	public static Shifters shift;
	public static BallControl ball;
	public static Lifter lift;
	// NIVision.Rect rect = new NIVision.Rect(10, 10, 200, 200);

	Command autonomousCommand;
	// SendableChooser chooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		// RobotMap.table = NetworkTable.getTable("control");
		System.out.println("init");
		drivetrain = new DriveTrain();
		gimbal = new Gimbal();
		shift = new Shifters();
		ball = new BallControl();
		lift = new Lifter();
		oi = new OI();
		RobotMap.camserver.startAutomaticCapture("cam1");
		// RobotMap.cam.setFPS(1000);
		// open the camera at the IP address assigned. This is the IP address
		// that the camera
		// can be accessed through the web interface.
		// chooser = new SendableChooser();
		// chooser.addDefault("autonomous", new Move(1));
		// chooser.addObject("My Auto", new MyAutoCommand());
		// SmartDashboard.putData("Auto mode", chooser);
		// RobotMap.camserver.startAutomaticCapture("cam0");
		RobotMap.auto.addObject("lowBar", RobotMap.path = 0);
		RobotMap.auto.addObject("driving defence", RobotMap.path = 1);
		RobotMap.auto.addObject("cheval", RobotMap.path = 2);
		RobotMap.auto.addObject("portical", RobotMap.path = 3);
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
		autonomousCommand = new Autonomous(RobotMap.path);
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
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		System.out.println("auto");
		Scheduler.getInstance().run();
		// RobotMap.camera.getImage(RobotMap.frame);
		// NIVision.imaqSetImageSize(RobotMap.frame, 640, 480);
		// RobotMap.camserver.setImage(RobotMap.frame);
	}

	public void teleopInit() {
		System.out.println("teleopInit");
		// Robot.drivetrain.resetGyro();
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		System.out.println("teleop");
		Scheduler.getInstance().run();
		// RobotMap.camera.getImage(RobotMap.frame);
		// NIVision.imaqSetImageSize(RobotMap.frame, 640, 480);
		// RobotMap.camserver.setImage(RobotMap.frame);
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		System.out.println("test");
		LiveWindow.run();
		// RobotMap.camera.getImage(RobotMap.frame);
		// NIVision.imaqSetImageSize(RobotMap.frame, 640, 480);
		// RobotMap.camserver.setImage(RobotMap.frame);
	}
}
