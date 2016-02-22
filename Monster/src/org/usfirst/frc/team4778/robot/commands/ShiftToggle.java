package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShiftToggle extends Command {

	boolean finished = false;

	public ShiftToggle() {
		requires(Robot.shift);
	}

	protected void initialize() {
		System.out.println("-shift-init");
	}

	protected void execute() {
		System.out.println("-shift-exe");
		if (Robot.shift.getstate()) {
			Robot.shift.shift(false);
		} else {
			Robot.shift.shift(true);
		}
		finished = true;
	}

	protected boolean isFinished() {
		return finished;
	}

	protected void end() {
		System.out.println("-shift-end");
	}

	protected void interrupted() {
		end();
	}
}
