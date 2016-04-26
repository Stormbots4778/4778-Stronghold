package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.commands.BallRoller;
import org.usfirst.frc.team4778.robot.commands.SetBallArm;

public class AutoPortcullis extends Auto {
	
	public AutoPortcullis(int defenseId, boolean shouldScore) {
		super(defenseId, shouldScore);
	}

	public void runBreach() {
		System.out.println("-start portcullis auto");
		
		addSequential(new SetBallArm(true));
		addSequential(new BallRoller(-1));
		//addSequential(new EnterDefense(-0.8));
		
		System.out.println("-end portcullis auto");
	}
}
