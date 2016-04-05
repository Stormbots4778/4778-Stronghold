package org.usfirst.frc.team4778.robot.commands.autonomous;

public class AutoPortcullis extends Auto {
	
	public AutoPortcullis(int defenseId, boolean shouldScore, boolean shouldCrossAgain) {
		super(defenseId, shouldScore, shouldCrossAgain);
	}
	
	public void init() {

	}

	public void runBreach(boolean shouldCrossAgain) {
		System.out.println("-start portcullis auto");
		

		System.out.println("-end portcullis auto");
	}
}
