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
import org.usfirst.frc.team4778.robot.subsystems.Lights;
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
	public static Lights light;

	public static LiftMechanism lift;
	public static ManipulatorLift ball;
	public static Intake in;

	public static Command autonomousCommand;

	public void robotInit() {
		System.out.println("init");

		drivetrain = new DriveTrain();
		lift = new LiftMechanism();
		shift = new Shifters();
		light = new Lights();
		ball = new ManipulatorLift();
		in = new Intake();
		oi = new OI();
		initSmartDashboard();
		updateSmartDashboard();
	}

	public void initSmartDashboard() {
		System.out.println("+robot init-smartdashboard");
		// 1 is the temporary defenseId
		RobotMap.auto.addObject("Low Bar", new AutoLow(false));
		RobotMap.auto.addObject("Ramparts | Moat", new AutoRamparts(1, false));
		RobotMap.auto.addObject("Rough Terrain | Rock Wall", new AutoGeneral(1, false));
		RobotMap.auto.addObject("Cheval De Frise", new AutoCheval(1, false));
		RobotMap.auto.addObject("No Autonomous", new AutoNone());
		RobotMap.auto.addDefault("switch", null);
		// SmartDashboard.putBoolean("Cross Twice", crossTwice);
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

		RobotMap.isTeleop = false;
		final boolean state1 = OI.nip.getRawButton(6);
		final boolean state2 = OI.nip.getRawButton(7);
		final boolean state3 = OI.nip.getRawButton(8);
		if (RobotMap.auto.getSelected() == null) {
			if (state1 == false && state2 == false && state3 == false) {
				autonomousCommand = new AutoNone();
			} else if (state1 == true && state2 == false && state3 == false) {
				autonomousCommand = null;
			} else if (state1 == true && state2 == true && state3 == false) {
				Robot.ball.move(false);
				autonomousCommand = new AutoLow(false);
			} else if (state1 == true && state2 == true && state3 == true) {
				autonomousCommand = new AutoRamparts(1, false);
			} else if (state1 == false && state2 == true && state3 == true) {
				autonomousCommand = new AutoGeneral(1, false);
			} else if (state1 == true && state2 == false && state3 == true) {
				// autonomousCommand = new Moat(1, false);
			} else {
				autonomousCommand = null;
			}
		} else {
			autonomousCommand = (Command) RobotMap.auto.getSelected();
		}
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	public void autonomousPeriodic() {
		System.out.println("+robot update-autonomous");

		RobotMap.isTeleop = false;

		Scheduler.getInstance().run();
		updateSmartDashboard();
	}

	public void teleopInit() {
		System.out.println("+robot init-teleoperated");

		RobotMap.isTeleop = true;

		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	public void teleopPeriodic() {
		System.out.println("+robot update-teleoperated");

		RobotMap.isTeleop = true;

		Scheduler.getInstance().run();
		updateSmartDashboard();
	}

	public void testPeriodic() {
		System.out.println("+robot update-test");

		LiveWindow.run();
		updateSmartDashboard();
	}
}