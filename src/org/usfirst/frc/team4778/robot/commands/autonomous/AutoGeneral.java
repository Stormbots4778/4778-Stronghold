package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.commands.Breach;
import org.usfirst.frc.team4778.robot.commands.SetBallArm;
import org.usfirst.frc.team4778.robot.commands.TurnToAngle;

public class AutoGeneral extends Auto {

	public AutoGeneral(int defenseId, boolean shouldScore) {
		super(defenseId, shouldScore);
	}

	public void runBreach() {
		System.out.println("-start general breach");

		addSequential(new SetBallArm(true));
		addSequential(new Breach(-0.99, 0, false));

		System.out.println("-end general breach");
	}
}
