package org.usfirst.frc.team4778.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BallControl extends Subsystem {

	private static VictorSP roller = new VictorSP(6);
	private static Solenoid arm1 = new Solenoid(3);
	private static Solenoid arm2 = new Solenoid(4);

	private boolean state;

	public void initDefaultCommand() {

	}

	public void setSpeed(double power) {
		System.out.println("#ball-setspeed");
		roller.set(power);
	}

	public void move(boolean on) {
		System.out.println("#ball-movearm");
		arm1.set(on);
		arm2.set(on);
		state = on;
	}

	public boolean getstate() {
		return state;
	}
}
