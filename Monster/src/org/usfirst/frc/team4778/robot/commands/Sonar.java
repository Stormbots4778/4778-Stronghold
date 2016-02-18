package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import arduino.IO;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Sonar extends Command {

	private double[] s = new double[91];
	private IO o = new IO();
	private double e = 0;
	private double a = 0;

	public Sonar() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drivetrain);
		requires(Robot.pan);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.drivetrain.setSpeed(0);
		Robot.drivetrain.setOutputRange(-1, 1);
		Robot.drivetrain.setSetpoint(0);
		Robot.drivetrain.getPIDController().setPID(0.5, 0, 0);
		Robot.pan.setang(90);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		for (int i = 45; i < 135; i++) {
			Robot.pan.setang(i);
			s[i - 45] = o.getsonar();
		}
		for (int i = 0; i < 90; i++) {
			if (s[i] > e) {
				e = s[i];
				a = i;
			}
		}
		a -= 45;
		Robot.drivetrain.enable();
		Robot.drivetrain.setInput(a);
		for (int i = 135; i > 45; i--) {
			Robot.pan.setang(i);
			s[i - 45] = o.getsonar();
		}
		for (int i = 0; i < 90; i++) {
			if (s[i] > e) {
				e = s[i];
				a = i;
			}
		}
		a -= 45;
		Robot.drivetrain.enable();
		Robot.drivetrain.setInput(a);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drivetrain.disable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
