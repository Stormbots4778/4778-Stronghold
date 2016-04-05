package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.commands.Breach;
import org.usfirst.frc.team4778.robot.commands.TurnToAngle;

public class AutoGeneral extends Auto {

	public AutoGeneral(int defenseId, boolean shouldScore, boolean shouldCrossAgain) {
		super(defenseId, shouldScore, shouldCrossAgain);
	}

	public void runBreach(boolean shouldCrossAgain) {
		System.out.println("-start general breach");

		addSequential(new Breach(-0.99, 0, false));
		if(shouldCrossAgain) {
			addSequential(new TurnToAngle(179));
			addSequential(new Breach(-0.99, 0, false));
			addSequential(new TurnToAngle(179));
		}

		System.out.println("-end general breach");
	}
}
