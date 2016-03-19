package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BreachCheval extends CommandGroup {

	public BreachCheval(double pow) {
		System.out.println("cheval");
		addSequential(new DriveOnDefence(pow));
		addSequential(new SetBallArm(false));
		addSequential(new ExitDefence(pow));
		addParallel(new SetBallArm(true));
	}
}
