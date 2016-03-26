package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.commands.Breach;
import org.usfirst.frc.team4778.robot.commands.Move;

public class AutoGeneral extends Auto {

	public AutoGeneral(int defenseId, boolean shouldScore) {
		super(defenseId, shouldScore);
	}
	
	public void init() {
		RobotMap.h = RobotMap.gyro.getAngle();
		RobotMap.f = RobotMap.gy2.getAngle();
		RobotMap.leftdrive.reset();
		RobotMap.rightdrive.reset();
	}
	
	public void runBreach() {
		System.out.println("-start general breach");
		
		addSequential(new Breach(-0.8)); // Runs at 80% power
		
		System.out.println("-end general breach");
	}
}
