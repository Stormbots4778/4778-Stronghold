package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.commands.EnterDefense;
import org.usfirst.frc.team4778.robot.commands.ExitDefense;
import org.usfirst.frc.team4778.robot.commands.Move;
import org.usfirst.frc.team4778.robot.commands.SetBallArm;

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

		addSequential(new EnterDefense(-0.8));
		addSequential(new SetBallArm(false));
		addSequential(new ExitDefense(-0.8));
		addSequential(new SetBallArm(true));
		addSequential(new Move(-1));
		
		System.out.println("-end cheval breach");
	}
}