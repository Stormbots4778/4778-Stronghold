package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.RobotMap;

public class AutoLow extends Auto {

	public AutoLow(boolean shouldScore) {
		super(0, shouldScore);
	}
	
	public void init() {
		RobotMap.h = RobotMap.gyro.getAngle();
		RobotMap.f = RobotMap.gy2.getAngle();
		RobotMap.leftdrive.reset();
		RobotMap.rightdrive.reset();
	}
	
	public void runBreach() {
		System.out.println("-start breach");
		
		//TODO Code low-bar breach
		
		System.out.println("-end breach");
	}
}
