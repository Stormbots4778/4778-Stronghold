package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.commands.Breach;
import org.usfirst.frc.team4778.robot.commands.Move;
import org.usfirst.frc.team4778.robot.commands.SetBallArm;
import org.usfirst.frc.team4778.robot.commands.TurnToAngle;

public class AutoRamparts extends Auto {

	public AutoRamparts(int defenseId, boolean shouldScore, boolean shouldCrossAgain) {
		super(defenseId, shouldScore, shouldCrossAgain);
	}

	public void init() {
		
	}

	public void runBreach(boolean shouldCrossAgain) {
		System.out.println("-start ramparts breach");

		addSequential(new SetBallArm(true));
		addSequential(new Breach(-1, 0, true));
		if(shouldCrossAgain) {
			addSequential(new TurnToAngle(179));
			addSequential(new Breach(-1, 0, true));
			addSequential(new Move(-1));
			addSequential(new TurnToAngle(179));
		}

		System.out.println("-end ramparts breach");
	}
}
