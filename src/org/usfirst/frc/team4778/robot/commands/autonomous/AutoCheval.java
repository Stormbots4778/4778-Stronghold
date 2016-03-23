package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.commands.BreachCheval;

public class AutoCheval extends Auto {

	public AutoCheval(int defenseId, boolean shouldScore) {
		super(defenseId, shouldScore);
	}
	
	public void init() {
		RobotMap.h = RobotMap.gyro.getAngle();
		RobotMap.f = RobotMap.gy2.getAngle();
		RobotMap.leftdrive.reset();
		RobotMap.rightdrive.reset();
	}
	
	public void runBreach() {
		System.out.println("-start breach");
		
		//TODO code cheval breach
		addSequential(new BreachCheval(-0.8));
		
		System.out.println("-end breach");
	}
}
