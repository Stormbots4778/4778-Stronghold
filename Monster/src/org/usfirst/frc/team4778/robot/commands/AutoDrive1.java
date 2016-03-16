package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDrive1 extends CommandGroup {

	public AutoDrive1() {
		RobotMap.gyro.reset();
		RobotMap.leftdrive.reset();
		RobotMap.rightdrive.reset();
		System.out.println("-start auto");
		addSequential(new SetBallArm(false));
		addSequential(new Breach(true));
		System.out.println("-end auto");
	}
}
