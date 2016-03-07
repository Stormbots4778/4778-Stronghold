package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {

	public Autonomous() {
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
<<<<<<< HEAD
		addSequential(new Breach(true));
		System.out.println("-end auto");
=======
		
		// All of these values are probs wrong
		//									\/
		
		if (sideOfField == "right") {
			addSequential(new Breach(true, 3));
			addSequential(new Move(156)); // 13 ft
			addSequential(new TurnToAngle(60));
			addSequential(new Move(30)); // 2.5 ft
		} else if (sideOfField == "left") {
			addSequential(new Breach(true, 3));
			addSequential(new Move(139.5)); // 11.625 ft
			addSequential(new TurnToAngle(-60));
			addSequential(new Move(71)); // 5.92 ft
		} else if (sideOfField == "low") {
			addSequential(new BreachLow(true, 3));
			addSequential(new Move(115)); // 9.6 ft
			addSequential(new TurnToAngle(-60));
			addSequential(new Move(89.5)); // 7.5 ft
			//TODO finish this
		}
		addSequential(new ReleaseBall());
		
		System.out.println("-end auto"); // Done :)
>>>>>>> Autonomous
	}
}
