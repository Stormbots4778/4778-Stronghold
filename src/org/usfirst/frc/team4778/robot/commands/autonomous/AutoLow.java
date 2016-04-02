package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.commands.BallRoller;
import org.usfirst.frc.team4778.robot.commands.Delay;
import org.usfirst.frc.team4778.robot.commands.Move;
import org.usfirst.frc.team4778.robot.commands.SetBallArm;
import org.usfirst.frc.team4778.robot.commands.TurnToAngle;

public class AutoLow extends Auto {

	boolean score;

	public AutoLow(boolean shouldScore) {
		super(0, shouldScore);
		score = shouldScore;
		init();
		runBreach();
	}

	public void init() {
		// RobotMap.h = RobotMap.gyro.getAngle();
		// RobotMap.f = RobotMap.gy2.getAngle();
		RobotMap.leftdrive.reset();
		RobotMap.rightdrive.reset();
	}

	public void runBreach() {
		System.out.println("-start breach");

		// TODO Code low-bar breach

		addSequential(new SetBallArm(false));
		addSequential(new Move(100));
		if (score) {
			addSequential(new SetBallArm(true));
			addSequential(new TurnToAngle(59));
			addSequential(new Move(135.5));
			addSequential(new SetBallArm(false));
			addSequential(new Delay(750));
			addSequential(new BallRoller(-1), 2);
		}
		System.out.println("-end breach");
	}
}
