package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import pid.PIDController;

/**
 *
 */
public class VisionTrack extends Command {

	NetworkTable table;
	PIDController pid;
	double output = 0;
	double[] defaultVal = new double[0];
	double xav = 0;
	double yav = 0;

	public VisionTrack() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drivetrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		table = NetworkTable.getTable("GRIP/contours");
		pid = new PIDController(0.0, 0.0, 0.0, 320); // image w640 h480 pixels
		pid.setOnTargetOffset(1);
		pid.setOutputLimits(-1, 1);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double[] y = table.getNumberArray("centerY", defaultVal);
		double[] x = table.getNumberArray("centerX", defaultVal);
		for (int i = 0; i < x.length; i++) {
			xav += x[i];
		}
		for (int i = 0; i < y.length; i++) {
			yav += y[i];
		}
		xav /= x.length;
		yav /= y.length;
		output = pid.computePID(xav);
		Robot.drivetrain.tankDrive(-output, output);
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
