package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GimMove extends Command {

	int angleU;
	int angle;
	boolean isFinished = false;

	public GimMove(int angU, int ang) {
		angleU = angU;
		angle = ang;
		requires(Robot.gimbal);
	}

	protected void initialize() {
		System.out.println("-gim-init");
	}

	protected void execute() {
		System.out.println("-gim-exe");
		Robot.gimbal.change(angleU, angle);
		isFinished = true;
	}

	protected boolean isFinished() {
		return isFinished;
	}

	protected void end() {
		System.out.println("-gim-end");
	}

	protected void interrupted() {
		end();
	}
}
