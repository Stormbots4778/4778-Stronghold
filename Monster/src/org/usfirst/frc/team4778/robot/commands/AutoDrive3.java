package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDrive3 extends CommandGroup {
    
    public  AutoDrive3() {
    	RobotMap.gyro.reset();
		RobotMap.leftdrive.reset();
		RobotMap.rightdrive.reset();
		System.out.println("-start auto");
		// code
		System.out.println("-end auto");
    }
}
