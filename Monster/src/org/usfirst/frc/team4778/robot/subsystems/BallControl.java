package org.usfirst.frc.team4778.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BallControl extends Subsystem {

	private static VictorSP roller = new VictorSP(6);

	public void initDefaultCommand() {

	}

	public void setInOutSpeed(double power) {
		roller.set(power);
	}

	public void moveArm() {

	}
}
