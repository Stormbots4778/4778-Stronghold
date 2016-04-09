package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.commands.Breach;
import org.usfirst.frc.team4778.robot.commands.SetBallArm;

public class AutoGeneral extends Auto {

	public AutoGeneral(int defenseId, boolean shouldScore) {
		super(defenseId, shouldScore);
	}

	public void runBreach() {
		System.out.println("-start general breach");
		addSequential(new SetBallArm(false));
		addSequential(new Breach(-0.99, 0, false));
		addSequential(new SetBallArm(true));

		System.out.println("-end general breach");
	}
}
