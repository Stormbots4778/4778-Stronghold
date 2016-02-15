package org.usfirst.frc.team4778.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lifter extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private static Solenoid p1 = new Solenoid(3);
	private static Solenoid p2 = new Solenoid(4);

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void moveArm(boolean on) {
		p1.set(on);
		p2.set(on);
	}

	public boolean getarm() {
		return p1.get();
	}
}
