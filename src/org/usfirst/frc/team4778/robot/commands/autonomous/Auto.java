package org.usfirst.frc.team4778.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auto extends CommandGroup {
	
    public  Auto(int defenseId, boolean shouldScore) {
    	init();
    	runBreach();
    	if(shouldScore) {
    		runScore(defenseId);
    	}
    }
    
    public void init() {
    	
    }
    
    public void runBreach() {
    	
    }
    
    public void runScore(int defenseId) {
    	//TODO Will code this last
    }
}
