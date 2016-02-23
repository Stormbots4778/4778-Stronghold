package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ReleaseBall extends Command {

	public ReleaseBall() {
		requires(Robot.ball);
	}

	protected void initialize() {
		System.out.println("-rball-init");
	}

	protected void execute() {
		System.out.println("-rball-exe");
		Robot.ball.setSpeed(-0.3);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		System.out.println("-rball-end");
		Robot.ball.setSpeed(0);

	}

	protected void interrupted() {
		end();
	}
}
