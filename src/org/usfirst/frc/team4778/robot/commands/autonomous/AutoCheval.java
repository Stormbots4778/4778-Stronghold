package org.usfirst.frc.team4778.robot.commands.autonomous;

public class AutoCheval extends Auto {

	public int defenseId;
	public boolean shouldScore;

	public AutoCheval(int defenseId, boolean shouldScore, boolean shouldCrossAgain) {
		super(defenseId, shouldScore, shouldCrossAgain);
		this.defenseId = defenseId;
		this.shouldScore = shouldScore;
	}

	public void init() {

	}

	public void runBreach(boolean shouldCrossAgain) {
		System.out.println("-start cheval breach");

		//TODO code here
		
		System.out.println("-end cheval breach");
	}
}
