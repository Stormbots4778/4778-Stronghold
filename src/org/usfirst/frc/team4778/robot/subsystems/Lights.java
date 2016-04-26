package org.usfirst.frc.team4778.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lights extends Subsystem {

	private final Relay Headlights;
	
	public Lights() {
		Headlights = new Relay(0);
	}

	public void on() {
		Headlights.set(Relay.Value.kOn);
	}
	
	public void off() {
		Headlights.set(Relay.Value.kOff);
	}
	
	public void initDefaultCommand() {
		
	}
}
