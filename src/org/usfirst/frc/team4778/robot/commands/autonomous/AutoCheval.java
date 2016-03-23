package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.commands.BreachCheval;

public class AutoCheval extends Auto {

	public AutoCheval(int defenseId) {
		super(defenseId);
	}
	
	public void init() {
		RobotMap.h = RobotMap.gyro.getAngle();
		RobotMap.f = RobotMap.gy2.getAngle();
		RobotMap.leftdrive.reset();
		RobotMap.rightdrive.reset();
	}
	
	public void runAuto() {
		System.out.println("-start auto");
		
		//TODO code cheval autonomous
		addSequential(new BreachCheval(-0.8));
		
		System.out.println("-end auto");
	}
}
