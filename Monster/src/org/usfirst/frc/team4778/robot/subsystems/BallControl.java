package org.usfirst.frc.team4778.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BallControl extends Subsystem {

	private static VictorSP roller = new VictorSP(6);
	private static Solenoid up = new Solenoid(2);
	private static Solenoid down = new Solenoid(3);

	private boolean state;

	public void initDefaultCommand() {

	}

	public void setSpeed(double power) {
		System.out.println("#ball-setspeed");
		roller.set(power);
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
