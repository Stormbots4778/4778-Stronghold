package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.commands.BreachCheval;

public class AutoCheval extends Auto {

	public int defenseId;
	public boolean shouldScore;

	public AutoCheval(int defenseId, boolean shouldScore, boolean shouldCrossAgain) {
		super(defenseId, shouldScore, shouldCrossAgain);
		this.defenseId = defenseId;
		this.shouldScore = shouldScore;
	}

	public void runBreach(boolean shouldCrossAgain) {
		System.out.println("-start cheval breach");

		addSequential(new BreachCheval(-0.8));
		
		System.out.println("-end cheval breach");
	}
}
