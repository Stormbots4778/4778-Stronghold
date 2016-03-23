package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLow extends Auto {

	public AutoLow(int direction, boolean shouldScore) {
		super(direction, shouldScore);
	}
	
	public void init() {
		RobotMap.gyro.reset();
		RobotMap.leftdrive.reset();
		RobotMap.rightdrive.reset();
	}
	
	public void runBreach() {
		System.out.println("-start breach");
		
		//TODO Code low-bar breach
		
		System.out.println("-end breach");
	}
}
