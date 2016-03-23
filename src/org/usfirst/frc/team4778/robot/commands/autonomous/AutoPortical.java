package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.RobotMap;

public class AutoPortical extends Auto {
    
    public  AutoPortical(int defenseId, boolean shouldScore) {
    	super(defenseId, shouldScore);
    }
    
    public void init() {
    	RobotMap.gyro.reset();
		RobotMap.leftdrive.reset();
		RobotMap.rightdrive.reset();
    }
    
    public void runAuto() {
		System.out.println("-start auto");
		
		//TODO code portical autonomous
		
		System.out.println("-end auto");
    }
}
