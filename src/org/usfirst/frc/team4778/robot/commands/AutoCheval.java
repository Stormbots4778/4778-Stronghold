package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCheval extends CommandGroup {
    
    public  AutoCheval(int pos) {
       switch(pos){
       case 1:
    	   RobotMap.h = 0;
   		RobotMap.f = 0;
   		RobotMap.gyro.reset();
   		RobotMap.gy2.reset();
   		RobotMap.leftdrive.reset();
   		RobotMap.rightdrive.reset();
   		System.out.println("-start auto");
   		//code
   		System.out.println("-end auto");
   		break;
       case 2:
    	   RobotMap.h = 0;
   		RobotMap.f = 0;
   		RobotMap.gyro.reset();
   		RobotMap.gy2.reset();
   		RobotMap.leftdrive.reset();
   		RobotMap.rightdrive.reset();
   		System.out.println("-start auto");
   		//code
   		System.out.println("-end auto");
   		break;
       case 3:
    	   RobotMap.h = 0;
   		RobotMap.f = 0;
   		RobotMap.gyro.reset();
   		RobotMap.gy2.reset();
   		RobotMap.leftdrive.reset();
   		RobotMap.rightdrive.reset();
   		System.out.println("-start auto");
   		//code
   		System.out.println("-end auto");
   		break;
       case 4:
    	   RobotMap.h = 0;
   		RobotMap.f = 0;
   		RobotMap.gyro.reset();
   		RobotMap.gy2.reset();
   		RobotMap.leftdrive.reset();
   		RobotMap.rightdrive.reset();
   		System.out.println("-start auto");
   		//code
   		System.out.println("-end auto");
   		break;
       }
    }
}
