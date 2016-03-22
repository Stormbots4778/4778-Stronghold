package org.usfirst.frc.team4778.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ManipulatorLift extends Subsystem {

	private static Solenoid up = new Solenoid(2);
	private static Solenoid down = new Solenoid(3);

	private boolean state;

	public void initDefaultCommand() {

	}

	public void move(boolean on) {
		System.out.println("#ball-movearm");
		up.set(on);
		down.set(!on);
		state = on;
	}

	public boolean getstate() {
		return state;
	}
}
