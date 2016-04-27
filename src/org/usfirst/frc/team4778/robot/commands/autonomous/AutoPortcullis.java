package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.commands.BreachPort;
import org.usfirst.frc.team4778.robot.commands.SetBallArm;

public class AutoPortcullis extends Auto {

	public AutoPortcullis(int defenseId, boolean shouldScore) {
		super(defenseId, shouldScore);
	}

	public void runBreach() {
		System.out.println("-start portcullis auto");
		addSequential(new SetBallArm(true));
		addSequential(new BreachPort(-0.5));
		System.out.println("-end portcullis auto");
	}
}
