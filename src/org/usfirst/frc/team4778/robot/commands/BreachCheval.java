package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class BreachCheval extends CommandGroup {

	public BreachCheval(double power) {
		System.out.println("-exe Cheval De Frise");
		
		addSequential(new EnterCheval(power));
		addSequential(new SetBallArm(false));
		addSequential(new ExitCheval(power));
		addSequential(new SetBallArm(true));
		addSequential(new Move(-1));
		
		System.out.println("-end-exe Cheval De Frise");
	}
}
