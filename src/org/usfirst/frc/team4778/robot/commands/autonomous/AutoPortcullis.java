package org.usfirst.frc.team4778.robot.commands.autonomous;

public class AutoPortcullis extends Auto {

	public int defenseId;
	public boolean shouldScore;

	public AutoPortcullis(int defenseId, boolean shouldScore) {
		super(defenseId, shouldScore);
		this.defenseId = defenseId;
		this.shouldScore = shouldScore;
	}

	public void init() {

	}

	public void runAuto() {
		System.out.println("-start portcullis auto");
		
		

		System.out.println("-end portcullis auto");
	}
}
