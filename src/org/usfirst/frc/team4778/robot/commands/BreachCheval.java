package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class BreachCheval extends CommandGroup {

	public BreachCheval(double power) {
		System.out.println("-exe Cheval De Frise");
		
		addSequential(new DriveOnDefence(power));
		addSequential(new SetBallArm(false));
		addSequential(new ExitDefence(power));
		addParallel(new SetBallArm(true));
		
		System.out.println("-end-exe Cheval De Frise");
	}
}
