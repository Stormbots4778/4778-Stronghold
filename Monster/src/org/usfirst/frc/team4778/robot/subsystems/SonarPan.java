package org.usfirst.frc.team4778.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SonarPan extends Subsystem {
	private Servo spin = new Servo(9);
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void setang(double ang) {
		spin.setAngle(ang);
	}
}
