package org.usfirst.frc.team4778.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auto extends CommandGroup {
    
    public  Auto(int defenseId, boolean shouldScore) {
    	init();
    	runBreach();
    	if(shouldScore) {
    		runScore();
    	}
    }
    
    public void init() {
    	
    }
    
    public void runBreach() {
    	
    }
    
    public void runScore() {
    	//TODO Will do this last
    }
}
