package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class BallRoller extends Command {

	public int direction = 0;
	
	public BallRoller(int direction) {
		requires(Robot.in);
		if(direction > 1 || direction < -1) {
			this.direction = direction;
		} else {
			end();
		}
	}

	protected void initialize() {
		System.out.println("-init ReleaseBall");
		
		// Nothing to initialize...
		
		System.out.println("-end-init ReleaseBall");
	}

	protected void execute() {
		System.out.println("-exe ReleaseBall");
		
		Robot.in.setSpeed(direction);
		
		System.out.println("-end-exe ReleaseBall");
	}
	

	protected void end() {
		Robot.in.setSpeed(0);
		
		System.out.println("-end ReleaseBall");
	}

	protected void interrupted() {end();}
	protected boolean isFinished() {return false;}
}
