package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetShifting extends Command {

	boolean isFinished = false;
	boolean state = true;

	public SetShifting(boolean state) {
		requires(Robot.shift);
		this.state = state;
	}

	protected void initialize() {
		System.out.println("-init SetShifting");
		
		// Nothing here...
		
		System.out.println("-end-init SetShifting");
	}

	protected void execute() {
		System.out.println("-exe SetShifting");
		
		Robot.shift.shift(state);
		isFinished = true;
		
		System.out.println("-end-exe SetShifting");
	}
	
	protected void end() {
		System.out.println("-end SetShifting");
	}

	protected boolean isFinished() {return isFinished;}
	protected void interrupted() {}
}
