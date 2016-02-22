package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LiftToggle extends Command {

	private boolean isFinished = false;

	public LiftToggle() {
		requires(Robot.lift);
	}

	protected void initialize() {
		System.out.println("-lift-init");
	}

	protected void execute() {
		System.out.println("-lift-exe");
		if (Robot.lift.getstate()) {
			Robot.lift.move(false);
		} else {
			Robot.lift.move(true);
		}
		isFinished = true;
	}

	protected boolean isFinished() {
		return isFinished;
	}

	protected void end() {
		System.out.println("-lift-end");
	}

	protected void interrupted() {
		end();
	}
}
