package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Illuminate extends Command {
	
	boolean isFinished = false;
	boolean isOn = false;
	
    public Illuminate(boolean isOn) {
    	requires(Robot.light);
    	this.isOn = isOn;
    }

    protected void initialize() {
    	System.out.println("-init Illuminate");
		
		// Nothing here...
		
		System.out.println("-end-init Illuminate");
    }
    
    protected void execute() {
    	if(isOn) {
    		Robot.light.on();
    	} else {
    		Robot.light.off();
    	}
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	end();
    }
    
    protected boolean isFinished() {
        return false;
    }
}
