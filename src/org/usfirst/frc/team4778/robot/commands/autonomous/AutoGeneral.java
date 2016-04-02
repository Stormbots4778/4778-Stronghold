package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.commands.BallRoller;
import org.usfirst.frc.team4778.robot.commands.Breach;
import org.usfirst.frc.team4778.robot.commands.Move;
import org.usfirst.frc.team4778.robot.commands.SetBallArm;
import org.usfirst.frc.team4778.robot.commands.TurnToAngle;

public class AutoGeneral extends Auto {
	int def;
	boolean s;

	public AutoGeneral(int defenseId, boolean shouldScore) {
		super(defenseId, shouldScore);
		def = defenseId;
		s = shouldScore;
		init();
		runBreach();
	}

	public void init() {
		//RobotMap.h = RobotMap.gyro.getAngle();
		//RobotMap.f = RobotMap.gy2.getAngle();
		RobotMap.leftdrive.reset();
		RobotMap.rightdrive.reset();
	}

	public void runBreach() {
		System.out.println("-start general breach");

		switch (def) {
		case 1:
			addSequential(new Breach(-0.8));
			if (s) {
				addSequential(new Move(138));
				addSequential(new TurnToAngle(59));
				addSequential(new Move(74));
				addParallel(new SetBallArm(true));
				addSequential(new BallRoller(-1), 2000);
			}
			break;
		case 2:
			addSequential(new Breach(-0.8));
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
			addSequential(new Breach(-0.8));
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
			addSequential(new Breach(-0.8));
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

		System.out.println("-end general breach");
	}
}
