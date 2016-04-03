package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.commands.Move;
import org.usfirst.frc.team4778.robot.commands.SetBallArm;

public class AutoLow extends Auto {

	public AutoLow(boolean shouldScore) {
		super(0, shouldScore);
	}

	public void init() {

	}

	public void runBreach() {
		System.out.println("-start low-bar breach");

		addSequential(new SetBallArm(false));
		addSequential(new Move(200));
		
		System.out.println("-end low-bar breach");
	}
}
