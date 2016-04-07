package org.usfirst.frc.team4778.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shifters extends Subsystem {

	private static Solenoid sol = new Solenoid(0);
	
	public void initDefaultCommand() {
		
	}

	public void shift(boolean on) {
		System.out.println("#exe Shifters shift(state)");
		
		sol.set(on);
		
		System.out.println("#end-exe Shifters shift(state)");
	}
}
