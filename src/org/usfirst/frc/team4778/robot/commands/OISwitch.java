package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class OISwitch extends Command {

	boolean isTeleop = false;
	boolean isOn = false;
	int switchN = 0;

	public OISwitch(boolean isTeleop, int switchN, boolean isOn) {
		this.isTeleop = isTeleop;
		this.switchN = switchN;
		this.isOn = isOn;
	}

	protected void execute() {
		Robot.ball.move(true);

	}

	protected void end() {
		Robot.ball.move(false);
	}

	protected void initialize() {
	}

	protected void interrupted() {
		end();
	}

	protected boolean isFinished() {
		return false;
	}
}
