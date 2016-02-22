package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Reverse extends Command {

	boolean finished = false;

	public Reverse() {

	}

	protected void initialize() {
		System.out.println("-reverse-init");
	}

	protected void execute() {
		System.out.println("-reverse-exe");
		if (RobotMap.dir) {
			RobotMap.dir = false;
		} else {
			RobotMap.dir = true;
		}
		finished = true;
	}

	protected boolean isFinished() {
		return finished;
	}

	protected void end() {
		System.out.println("-reverse-end");
	}

	protected void interrupted() {
		end();
	}
}
