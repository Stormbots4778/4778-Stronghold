package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.commands.BallRoller;
import org.usfirst.frc.team4778.robot.commands.Move;
import org.usfirst.frc.team4778.robot.commands.SetBallArm;
import org.usfirst.frc.team4778.robot.commands.TurnToAngle;

public class AutoPortcullis extends Auto {

	int def;
	boolean s;

	public AutoPortcullis(int defenseId, boolean shouldScore) {
		super(defenseId, shouldScore);
		def = defenseId;
		s = shouldScore;
		init();
		runBreach();
	}

	public void init() {
		//RobotMap.gyro.reset();
		RobotMap.leftdrive.reset();
		RobotMap.rightdrive.reset();
	}

	public void runAuto() {
		System.out.println("-start auto");

		switch (def) {
		case 1:
			// breach
			if (s) {
				addSequential(new Move(138));
				addSequential(new TurnToAngle(59));
				addSequential(new Move(74));
				addParallel(new SetBallArm(true));
				addSequential(new BallRoller(-1), 2000);
			}
			break;
		case 2:
			// breach
			if (s) {
				addSequential(new Move(41));
				addSequential(new TurnToAngle(-31));
				addSequential(new Move(112));
				addSequential(new TurnToAngle(59));
				addSequential(new Move(74));
				addParallel(new SetBallArm(true));
				addSequential(new BallRoller(-1), 2000);
			}
			break;
		case 3:
			// breach
			if (s) {
				addSequential(new Move(70));
				addSequential(new TurnToAngle(33));
				addSequential(new Move(98));
				addSequential(new TurnToAngle(-57));
				addSequential(new Move(41));
				addParallel(new SetBallArm(true));
				addSequential(new BallRoller(-1), 2000);
			}
			break;
		case 4:
			// breach
			if (s) {
				addSequential(new Move(153));
				addSequential(new TurnToAngle(59));
				addSequential(new Move(41));
				addParallel(new SetBallArm(true));
				addSequential(new BallRoller(-1), 2000);
			}
			break;
		default:

		}

		System.out.println("-end auto");
	}
}
