package org.usfirst.frc.team4778.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BallControl extends Subsystem {

	private static VictorSP roller = new VictorSP(6);
	private static Solenoid arm = new Solenoid(5);

	public void initDefaultCommand() {

	}

	public void setInOutSpeed(double power) {
		System.out.println("#ball-setspeed");
		roller.set(power);
	}

	public void moveArm(boolean on) {
		System.out.println("#ball-movearm");
		arm.set(on);
	}

	public boolean getArm() {
		return arm.get();
	}
}
