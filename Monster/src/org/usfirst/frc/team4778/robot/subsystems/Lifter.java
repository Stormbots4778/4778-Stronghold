package org.usfirst.frc.team4778.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lifter extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private static Solenoid up = new Solenoid(4);
	private static Solenoid down = new Solenoid(5);

	private boolean state;

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void move(boolean on) {
		System.out.println("#lift-movearm");
		up.set(on);
		down.set(!on);
		state = on;
	}

	public boolean getstate() {
		return state;
	}
}
