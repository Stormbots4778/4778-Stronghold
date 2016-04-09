package org.usfirst.frc.team4778.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

	private static VictorSP roller = new VictorSP(6);

	public void initDefaultCommand() {
		
	}

	public void setSpeed(double power) {
		System.out.println("#exe Intake setSpeed(power)");
		
		roller.set(-power);
		
		System.out.println("#end-exe Intake setSpeed(power)");
	}
}
