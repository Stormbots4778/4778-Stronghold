package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLow extends CommandGroup {

	public AutoLow() {
		RobotMap.gyro.reset();
		RobotMap.leftdrive.reset();
		RobotMap.rightdrive.reset();
		System.out.println("-start auto");
		// code
		System.out.println("-end auto");
	}
}
