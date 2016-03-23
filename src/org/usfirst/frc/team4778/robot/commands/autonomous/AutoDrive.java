package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.commands.Breach;
import org.usfirst.frc.team4778.robot.commands.Move;

public class AutoDrive extends Auto {

	public AutoDrive(int defenseId, boolean shouldScore) {
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
		
		//TODO code drive breach
		addSequential(new Breach(-0.8));
		addSequential(new Move(36));
		
		System.out.println("-end breach");
	}
}
