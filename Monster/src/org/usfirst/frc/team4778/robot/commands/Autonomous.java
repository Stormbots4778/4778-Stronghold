package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {

	public Autonomous(int path) {
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
		switch (path) {
		case 0:
			// low bar
			addSequential(new Breach(true));
			addSequential(new Move(100));
			addSequential(new TurnToAngle(60));
			addSequential(new Move(100));
			addSequential(new ReleaseBall(), 2000);
			break;
		case 1:
			// driving defence
			break;
		case 2:
			// cheval
			break;
		case 3:
			// portical
			break;
		default:
			System.out.println("error: invalid auto");
			break;
		}
		System.out.println("-end auto");
	}
}
