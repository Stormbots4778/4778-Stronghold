package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TrapBall extends Command {

	public TrapBall() {
		requires(Robot.ball);
	}

	protected void initialize() {
		System.out.println("-tball-init");
	}

	protected void execute() {
		System.out.println("-tball-exe");
		Robot.ball.setInOutSpeed(0.3);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		System.out.println("-tball-end");

	}

	protected void interrupted() {
		end();
	}
}
