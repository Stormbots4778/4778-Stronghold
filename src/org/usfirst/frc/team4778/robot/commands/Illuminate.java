package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Illuminate extends Command {
	
	boolean isFinished = false;
	boolean isOn = false;
	boolean manual = false;
	
    public Illuminate(boolean isOn, boolean manual) {
    	requires(Robot.light);
    	this.isOn = isOn;
    	this.manual = manual;
    }

    protected void initialize() {
    	System.out.println("-init Illuminate");
		
		// Nothing here...
		
		System.out.println("-end-init Illuminate");
    }
    
    protected void execute() {
    	System.out.println("-exe Illuminate");
    	
    	if(isOn) {
    		if(manual) {
        		Robot.light.on();
    		} else {
        		Robot.light.on();
        		Robot.light.off();
        		Robot.light.on();
        		Robot.light.off();
        		Robot.light.on();
    		}
    	} else {
    		Robot.light.off();
    	}
    	
    	System.out.println("-end-exe Illuminate");
    }

    protected void end() {
    	System.out.println("-end Illuminate");
    }

    protected void interrupted() {
    	end();
    }
    
    protected boolean isFinished() {
        return false;
    }
}
