package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {

	public Autonomous(double path, double loc) {
		RobotMap.gyro.reset();
		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
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
