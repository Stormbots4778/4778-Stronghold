package org.usfirst.frc.team4778.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftMechanism extends Subsystem {
    
	private static VictorSP hook = new VictorSP(7);
	private static VictorSP winch = new VictorSP(8);

    public void initDefaultCommand() {
    	
    }
    
    public void setSpeed(double hookPower, double winchPower) {
		System.out.println("#exe Lift setSpeed(power)");
		
		hook.set(hookPower);
		winch.set(winchPower);
		
		System.out.println("#end-exe Lift setSpeed(power)");
	}
}

