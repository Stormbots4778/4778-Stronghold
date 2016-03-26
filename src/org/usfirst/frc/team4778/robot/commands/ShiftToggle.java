package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftToggle extends Command {

	boolean isFinished = false;

	public ShiftToggle() {
		requires(Robot.shift);
	}

	protected void initialize() {
		System.out.println("-init ShiftToggle");
		
		// Nothing here...
		
		System.out.println("-end-init ShiftToggle");
	}

	protected void execute() {
		System.out.println("-exe ShiftToggle");
		
		if (Robot.shift.getstate()) {
			Robot.shift.shift(false);
		} else {
			Robot.shift.shift(true);
		}
		isFinished = true;
		
		System.out.println("-end-exe ShiftToggle");
	}

	protected void end() {
		System.out.println("-end ShiftToggle");
	}

	protected void interrupted() {end();}
	protected boolean isFinished() {return isFinished;}
}
