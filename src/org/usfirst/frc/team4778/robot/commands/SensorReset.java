package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class SensorReset extends Command {

	public SensorReset() {
		
	}

	protected void initialize() {
		System.out.println("-init SensorReset");
		
		RobotMap.encoder.reset();
		RobotMap.h = 0;
		RobotMap.ahrs.reset();
		
		System.out.println("-end-init SensorReset");
	}

	protected void execute() {}
	protected boolean isFinished() {return false;}
	protected void end() {}
	protected void interrupted() {end();}
}
