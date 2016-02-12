package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.OI;
import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class TankDrive extends Command {

	public TankDrive() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drivetrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		RobotMap.table = NetworkTable.getTable("control");
	}

	// Called repeatedly when this Command is scheduled to run
	@SuppressWarnings("deprecation")
	protected void execute() {
		if (RobotMap.table.isConnected()) {
			Robot.drivetrain.tankDrive(RobotMap.table.getNumber("leftY"), RobotMap.table.getNumber("rightY"));
		} else {
			Robot.drivetrain.tankDrive(OI.joyleft, OI.joyright);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
