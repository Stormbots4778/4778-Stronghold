package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {

	public Autonomous(String sideOfField) {
		System.out.println("-start auto");
		
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
	}
}
