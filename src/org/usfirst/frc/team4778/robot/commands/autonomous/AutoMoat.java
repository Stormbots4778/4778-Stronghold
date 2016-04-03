package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.commands.Breach;
import org.usfirst.frc.team4778.robot.commands.TurnToAngle;

public class AutoMoat extends Auto {

	public AutoMoat(int defenseId, boolean shouldScore) {
		super(defenseId, shouldScore);
	}

	public void init() {
		
	}

	public void runBreach() {
		System.out.println("-start general breach");

		addSequential(new Breach(-1, 0, true));
		addSequential(new TurnToAngle(179));
		addSequential(new Breach(-1, 0, true));
		addSequential(new TurnToAngle(179));

		System.out.println("-end general breach");
	}
}
