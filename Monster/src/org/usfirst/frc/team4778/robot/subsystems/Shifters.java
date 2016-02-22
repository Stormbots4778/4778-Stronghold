package org.usfirst.frc.team4778.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shifters extends Subsystem {

	private static Solenoid in = new Solenoid(0);
	private static Solenoid out = new Solenoid(1);

	private boolean state;

	public void initDefaultCommand() {

	}

	public void shift(boolean on) {
		System.out.println("#shifters-shift");
		in.set(on);
		out.set(!on);
		state = on;
	}

	public boolean getstate() {
		return state;
	}
}
