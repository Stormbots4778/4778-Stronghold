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
	}

	protected void execute() {
		Robot.ball.setInOutSpeed(-0.3);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {

	}

	protected void interrupted() {
		end();
	}
}
