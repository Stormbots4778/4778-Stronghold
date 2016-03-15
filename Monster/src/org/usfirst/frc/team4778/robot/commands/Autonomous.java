package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {

	public Autonomous(double path, double loc) {
		RobotMap.gyro.reset();
		RobotMap.leftdrive.reset();
		RobotMap.rightdrive.reset();
		System.out.println("-start auto");
		switch ((int) path) {
		case 0:
			// low bar
			addSequential(new Breach(true));
			// addSequential(new SetBallArm(false));
			// addSequential(new Move(176));
			// addSequential(new TurnToAngle(60));
			// addSequential(new SetBallArm(true));
			// addSequential(new Move(120));
			// addSequential(new SetBallArm(false));
			// addSequential(new ReleaseBall(), 2000);
			break;
		case 1:
			// driving defence
			switch ((int) loc) {
			case 0:
				// | low | * | 0 | 0 | 0 |
				addSequential(new Breach(true));
				addSequential(new Move(110));
				addSequential(new TurnToAngle(60));
				addSequential(new Move(60));
				addSequential(new SetBallArm(false));
				addSequential(new Move(20));
				addSequential(new ReleaseBall(), 2000);
				break;
			case 1:
				// | low | 0 | * | 0 | 0 |
				break;
			case 2:
				// | low | 0 | 0 | * | 0 |
				break;
			case 3:
				// | low | 0 | 0 | 0 | * |
				break;
			default:
				System.out.println("error: invalid auto location");
				break;
			}
			break;
		case 2:
			// cheval
			switch ((int) loc) {
			case 0:
				// | low | * | 0 | 0 | 0 |
				break;
			case 1:
				// | low | 0 | * | 0 | 0 |
				break;
			case 2:
				// | low | 0 | 0 | * | 0 |
				break;
			case 3:
				// | low | 0 | 0 | 0 | * |
				break;
			default:
				System.out.println("error: invalid auto location");
				break;
			}
			break;
		case 3:
			// portical
			switch ((int) loc) {
			case 0:
				// | low | * | 0 | 0 | 0 |
				break;
			case 1:
				// | low | 0 | * | 0 | 0 |
				break;
			case 2:
				// | low | 0 | 0 | * | 0 |
				break;
			case 3:
				// | low | 0 | 0 | 0 | * |
				break;
			default:
				System.out.println("error: invalid auto location");
				break;
			}
			break;
		case 4:
			break;
		default:
			System.out.println("error: invalid auto");
			break;
		}
		System.out.println("-end auto");
	}
}
