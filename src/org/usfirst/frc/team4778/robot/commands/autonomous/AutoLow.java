package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.commands.BreachLow;
import org.usfirst.frc.team4778.robot.commands.SetBallArm;

public class AutoLow extends Auto {

	public AutoLow(boolean shouldScore, boolean shouldCrossAgain) {
		super(0, shouldScore, shouldCrossAgain);
	}

	public void init() {

	}

	public void runBreach(boolean shouldCrossAgain) {
		System.out.println("-start low-bar breach");

		addSequential(new SetBallArm(false));
		addSequential(new BreachLow(-0.8));
		addSequential(new SetBallArm(true));
		
		System.out.println("-end low-bar breach");
	}
}
