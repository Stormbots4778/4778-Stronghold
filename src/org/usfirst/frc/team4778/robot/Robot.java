package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.SensorReset;
import org.usfirst.frc.team4778.robot.commands.TankDrive;
import org.usfirst.frc.team4778.robot.commands.autonomous.AutoCheval;
import org.usfirst.frc.team4778.robot.commands.autonomous.AutoGeneral;
import org.usfirst.frc.team4778.robot.commands.autonomous.AutoLow;
import org.usfirst.frc.team4778.robot.commands.autonomous.AutoNone;
import org.usfirst.frc.team4778.robot.commands.autonomous.AutoRamparts;
import org.usfirst.frc.team4778.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4778.robot.subsystems.Intake;
import org.usfirst.frc.team4778.robot.subsystems.LiftMechanism;
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

	public static LiftMechanism lift;
	public static ManipulatorLift ball;
	public static Intake in;
	public static boolean crossTwice;

	Command autonomousCommand;

	public void robotInit() {
		System.out.println("init");
				
		drivetrain = new DriveTrain();
		lift = new LiftMechanism();
		shift = new Shifters();
		ball = new ManipulatorLift();
		in = new Intake();
		oi = new OI();
		initSmartDashboard();
		updateSmartDashboard();

	}

	public void initSmartDashboard() {
		System.out.println("+robot init-smartdashboard");
		
		// 1 is the temporary defenseId
		RobotMap.auto.addDefault("Low Bar", 					new AutoLow			(false, crossTwice));
		RobotMap.auto.addDefault("Ramparts", 					new AutoRamparts	(1, 	false, crossTwice));
		RobotMap.auto.addDefault("Rough Terrain | Rock Wall", 	new AutoGeneral		(1, 	false, crossTwice));
	//	RobotMap.auto.addDefault("Portcullis", 					new AutoPortcullis	(1, 	false, crossTwice));
		RobotMap.auto.addDefault("Cheval", 						new AutoCheval		(1, 	false, crossTwice));
		RobotMap.auto.addObject("No Autonomous", 				new AutoNone		());
		
		SmartDashboard.putBoolean("Cross Twice", crossTwice);
		SmartDashboard.putData("Reset Sensors", new SensorReset());
	}

	public void updateSmartDashboard() {
		System.out.println("+robot update-smartdashboard");

		SmartDashboard.putData("Auto Chooser", RobotMap.auto);
		
		SmartDashboard.putNumber("NavX Pitch (Actually Roll)", RobotMap.ahrs.getPitch());
		SmartDashboard.putNumber("NavX Yaw", RobotMap.ahrs.getYaw());
		SmartDashboard.putNumber("NavX Roll (Actually Pitch)", RobotMap.ahrs.getRoll());
						
		SmartDashboard.putNumber("Heading ", RobotMap.h);
		SmartDashboard.putNumber("Encoder L: ", RobotMap.leftdrive.getDistance());
		SmartDashboard.putNumber("Encoder R: ", RobotMap.rightdrive.getDistance());
		
		crossTwice = SmartDashboard.getBoolean("Cross Twice");
		SmartDashboard.putBoolean("Cross Twice", crossTwice);
	}

	public void disabledInit() {
		System.out.println("+robot init-disabled");
	}

	public void disabledPeriodic() {
		System.out.println("+robot update-disabled");

		Scheduler.getInstance().run();
		updateSmartDashboard();
	}

	public void autonomousInit() {
		System.out.println("+robot init-autonomous");
		
		autonomousCommand = (Command) RobotMap.auto.getSelected();
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	public void autonomousPeriodic() {
		System.out.println("+robot update-autonomous");

		Scheduler.getInstance().run();
		updateSmartDashboard();
	}

	public void teleopInit() {
		System.out.println("+robot init-teleoperated");
		
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	public void teleopPeriodic() {
		System.out.println("+robot update-teleoperated");

		Scheduler.getInstance().run();
		updateSmartDashboard();
	}

	public void testPeriodic() {
		System.out.println("+robot update-test");
		
		LiveWindow.run();
		updateSmartDashboard();
	}
}
