package org.usfirst.frc.team4778.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shifters extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private static Solenoid left = new Solenoid(0);
	private static Solenoid right = new Solenoid(1);

	private boolean state;

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void shift(boolean on) {
		System.out.println("#shifters-shift");
		left.set(on);
		right.set(on);
		state = on;
	}

	public boolean getstate() {
		return state;
	}
}
