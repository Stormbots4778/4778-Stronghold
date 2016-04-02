package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.OI;
import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TankDrive extends Command {

	public TankDrive() {
		requires(Robot.drivetrain);
	}

	protected void initialize() {
		System.out.println("-init TankDrive");
		
		// Nothing here...
		
		System.out.println("-end-init TankDrive");
	}

	protected void execute() {
		System.out.println("-exe TankDrive");
		
		Robot.drivetrain.tankDrive(OI.xbox);
		Robot.drivetrain.arcadeDrive(OI.joyleft, OI.joyright);
		
		System.out.println("-end-exe TankDrive");
	}

	protected void end() {
		System.out.println("-end TankDrive");
	}

	protected void interrupted() {end();}
	protected boolean isFinished() {return false;}
}
