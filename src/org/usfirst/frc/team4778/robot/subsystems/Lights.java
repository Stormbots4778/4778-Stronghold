package org.usfirst.frc.team4778.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Relay;


public class Lights extends Subsystem {

	private final Relay Headlights;
	
	public Lights() {
		Headlights = new Relay(9);
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
