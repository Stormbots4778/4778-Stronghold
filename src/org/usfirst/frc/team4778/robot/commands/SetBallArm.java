package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetBallArm extends Command {

	boolean isFinished = false;
	boolean state = true;

	public SetBallArm(boolean state) {
		requires(Robot.ball);
		this.state = state;
	}

	protected void initialize() {
		System.out.println("-init SetBallArm");
		
		// Nothing here...
		
		System.out.println("-end-init SetBallArm");
	}

	protected void execute() {
		System.out.println("-exe SetBallArm");
		
		Robot.ball.move(state);
		isFinished = true;
		
		System.out.println("-end-exe SetBallArm");
	}
	
	protected void end() {
		System.out.println("-end SetBallArm");
	}

	protected boolean isFinished() {return isFinished;}
	protected void interrupted() {end();}
}
