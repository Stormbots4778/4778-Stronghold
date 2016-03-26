package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLow extends CommandGroup {

	public AutoLow() {
		RobotMap.h = 0;
		RobotMap.f = 0;
		RobotMap.gyro.reset();
		RobotMap.gy2.reset();
		RobotMap.leftdrive.reset();
		RobotMap.rightdrive.reset();
		System.out.println("-start auto");
		// code
		addSequential(new SetBallArm(false));
		addSequential(new Move(230));
		addSequential(new TurnToAngle(60));
		addSequential(new SetBallArm(true));
		addSequential(new Move(190));
		addSequential(new SetBallArm(false));
		addSequential(new Move(10));
		System.out.println("-end auto");
	}
}
