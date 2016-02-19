package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Reverse extends Command {

	boolean finished = false;

	public Reverse() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("-reverse-init");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println("-reverse-exe");
		if (RobotMap.dir) {
			RobotMap.dir = false;
		} else {
			RobotMap.dir = true;
		}
		finished = true;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return finished;
	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println("-reverse-end");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
