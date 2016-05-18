package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.commands.Delay;
import org.usfirst.frc.team4778.robot.commands.EnterDefense;
import org.usfirst.frc.team4778.robot.commands.ExitDefense;
import org.usfirst.frc.team4778.robot.commands.Move;
import org.usfirst.frc.team4778.robot.commands.SetBallArm;

public class AutoCheval extends Auto {

	public int defenseId;
	public boolean shouldScore;

	public AutoCheval(int defenseId, boolean shouldScore) {
		super(defenseId, shouldScore);
		this.defenseId = defenseId;
		this.shouldScore = shouldScore;
	}

	public void runBreach() {
		System.out.println("-start cheval breach");

		addSequential(new SetBallArm(true));
		addSequential(new EnterDefense(-0.6, 20)); //TODO Find correct rate
		addSequential(new SetBallArm(false));
		addSequential(new Delay(800)); // 500 for comp bot
		addSequential(new ExitDefense(-0.95));
		addSequential(new SetBallArm(true));
		
		System.out.println("-end cheval breach");
	}
}