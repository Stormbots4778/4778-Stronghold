package org.usfirst.frc.team4778.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gimbal extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private Servo rotate = new Servo(4);
	private Servo up = new Servo(5);
	int u = 90;
	int r = 90;

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void change(int upi, int rotatei) {
		u += upi;
		r += rotatei;
		up.setAngle(u);
		rotate.setAngle(r);
	}

}
