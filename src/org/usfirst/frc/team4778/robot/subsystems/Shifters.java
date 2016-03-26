package org.usfirst.frc.team4778.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shifters extends Subsystem {

	private static Solenoid in = new Solenoid(0);
	private static Solenoid out = new Solenoid(1);

	private boolean state;

	public void initDefaultCommand() {
		
	}

	public void shift(boolean state) {
		System.out.println("#exe Shifters shift(state)");
		
		in.set(state);
		out.set(!state);
		this.state = state;
		
		System.out.println("#end-exe Shifters shift(state)");
	}

	public boolean getstate() {
		return state;
	}
}
