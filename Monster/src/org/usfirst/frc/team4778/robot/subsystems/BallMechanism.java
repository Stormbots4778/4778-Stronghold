package org.usfirst.frc.team4778.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BallMechanism extends Subsystem {
    
	private static VictorSP roller = new VictorSP(6);

    public void initDefaultCommand() {
    	
    }
    
    public void spinRoller() {
    	roller.set(0.3);
    }
    
	public void stop(double stoppingPower) {
		System.out.println("-stop");
		roller.set(stoppingPower);
		roller.set(0);
	}
    
}

