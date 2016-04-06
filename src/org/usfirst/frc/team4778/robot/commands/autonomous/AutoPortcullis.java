package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.commands.BallRoller;
import org.usfirst.frc.team4778.robot.commands.EnterDefense;

public class AutoPortcullis extends Auto {
	
	public AutoPortcullis(int defenseId, boolean shouldScore, boolean shouldCrossAgain) {
		super(defenseId, shouldScore, shouldCrossAgain);
	}

	public void runBreach(boolean shouldCrossAgain) {
		System.out.println("-start portcullis auto");
		
		addSequential(new BallRoller(-1));
		addSequential(new EnterDefense(-0.8));
		
		System.out.println("-end portcullis auto");
	}
}
