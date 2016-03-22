package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TrapBall extends Command {

	public TrapBall() {
		requires(Robot.in);
	}

	protected void initialize() {
		System.out.println("-tball-init");
	}

	protected void execute() {
		System.out.println("-tball-exe");
		Robot.in.setSpeed(1);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		System.out.println("-tball-end");
		Robot.in.setSpeed(0);
	}

	protected void interrupted() {
		end();
	}
}
