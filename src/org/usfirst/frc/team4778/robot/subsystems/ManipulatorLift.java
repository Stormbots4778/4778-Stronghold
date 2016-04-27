package org.usfirst.frc.team4778.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ManipulatorLift extends Subsystem {

	private static Solenoid up = new Solenoid(6);
	private static Solenoid down = new Solenoid(7);

	private boolean state;

	public void initDefaultCommand() {

	}

	public void move(boolean state) {
		System.out.println("#exe ManipulatorLift move(state)");
		
		up.set(state);
		down.set(!state);
		this.state = state;
		
		System.out.println("#end-exe ManipulatorLift move(state)");
	}

	public boolean getstate() {
		return state;
	}
}
