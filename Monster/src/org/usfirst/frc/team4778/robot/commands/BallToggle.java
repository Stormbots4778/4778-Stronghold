package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class BallToggle extends Command {

	private boolean finished = false;

	public BallToggle() {
		requires(Robot.ball);
	}

	protected void initialize() {
		System.out.println("-ball-init");
	}

	protected void execute() {
		System.out.println("-ball-exe");
		if (Robot.ball.getstate()) {
			Robot.ball.move(false);
		} else {
			Robot.ball.move(true);
		}
		finished = true;
	}

	protected boolean isFinished() {
		return finished;
	}

	protected void end() {
		System.out.println("-ball-end");
	}

	protected void interrupted() {
		end();
	}
}
