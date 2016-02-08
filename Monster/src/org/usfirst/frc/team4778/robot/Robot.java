
package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.Autonomous;
import org.usfirst.frc.team4778.robot.commands.TankDrive;
import org.usfirst.frc.team4778.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.hal.AccelerometerJNI;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static OI oi;
	public static TankDrive tankdrive;
	public static DriveTrain drivetrain;

	Command autonomousCommand;
	Sendable gyrodata;
	// SendableChooser chooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		System.out.println("init");
		oi = new OI();
		drivetrain = new DriveTrain();
		tankdrive = new TankDrive();
		SmartDashboard.putNumber("Gyro:", RobotMap.gyro.getAngle());
		SmartDashboard.putNumber("AccelerometerZ:", AccelerometerJNI.getAccelerometerZ());
		SmartDashboard.putNumber("AccelerometerY:", AccelerometerJNI.getAccelerometerY());
		SmartDashboard.putNumber("AccelerometerX:", AccelerometerJNI.getAccelerometerX());
		// chooser = new SendableChooser();
		// chooser.addDefault("autonomous", new Move(1));
		// chooser.addObject("My Auto", new MyAutoCommand());
		// SmartDashboard.putData("Auto mode", chooser);
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
		SmartDashboard.putNumber("Gyro:", RobotMap.gyro.getAngle());
		SmartDashboard.putNumber("AccelerometerZ:", AccelerometerJNI.getAccelerometerZ());
		SmartDashboard.putNumber("AccelerometerY:", AccelerometerJNI.getAccelerometerY());
		SmartDashboard.putNumber("AccelerometerX:", AccelerometerJNI.getAccelerometerX());
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
		autonomousCommand = new Autonomous();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

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
		SmartDashboard.putNumber("Gyro:", RobotMap.gyro.getAngle());
		SmartDashboard.putNumber("AccelerometerZ:", AccelerometerJNI.getAccelerometerZ());
		SmartDashboard.putNumber("AccelerometerY:", AccelerometerJNI.getAccelerometerY());
		SmartDashboard.putNumber("AccelerometerX:", AccelerometerJNI.getAccelerometerX());
	}

	public void teleopInit() {
		System.out.println("teleopInit");
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
		SmartDashboard.putNumber("Gyro:", RobotMap.gyro.getAngle());
		SmartDashboard.putNumber("AccelerometerZ:", AccelerometerJNI.getAccelerometerZ());
		SmartDashboard.putNumber("AccelerometerY:", AccelerometerJNI.getAccelerometerY());
		SmartDashboard.putNumber("AccelerometerX:", AccelerometerJNI.getAccelerometerX());
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		System.out.println("test");
		LiveWindow.run();
		SmartDashboard.putNumber("Gyro:", RobotMap.gyro.getAngle());
		SmartDashboard.putNumber("AccelerometerZ:", AccelerometerJNI.getAccelerometerZ());
		SmartDashboard.putNumber("AccelerometerY:", AccelerometerJNI.getAccelerometerY());
		SmartDashboard.putNumber("AccelerometerX:", AccelerometerJNI.getAccelerometerX());
	}
}
