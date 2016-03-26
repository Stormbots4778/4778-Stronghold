package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.RobotMap;

public class AutoCheval extends Auto {
    
    public  AutoCheval(int defenseId, boolean shouldScore) {
    	super(defenseId, shouldScore);
    }
    
    public void init() {
		RobotMap.h = RobotMap.gyro.getAngle();
		RobotMap.f = RobotMap.gy2.getAngle();
		RobotMap.leftdrive.reset();
		RobotMap.rightdrive.reset();
    }
    
    public void runBreach() {
		System.out.println("-start cheval breach");
		
		//TODO Code cheval breach
		
		System.out.println("-end cheval breach");
    }
}
