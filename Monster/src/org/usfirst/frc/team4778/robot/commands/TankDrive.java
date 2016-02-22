package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.OI;
import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TankDrive extends Command {

	public TankDrive() {
		requires(Robot.drivetrain);
	}

	protected void initialize() {
		System.out.println("-td-init");
		// RobotMap.table = NetworkTable.getTable("control");
	}

	protected void execute() {
		System.out.println("-td-exe");
		// if (RobotMap.table.isConnected()) {
		// Robot.drivetrain.tankDrive(RobotMap.table.getNumber("leftY"),
		// RobotMap.table.getNumber("rightY"));
		// } else {
		Robot.drivetrain.tankDrive(OI.joyleft, OI.joyright);
		// }
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		System.out.println("-td-end");
	}

	protected void interrupted() {
		end();
	}
}
