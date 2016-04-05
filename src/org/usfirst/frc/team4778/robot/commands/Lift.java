package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Lift extends Command {

	public int liftType = 0;

	public Lift(int liftType) {
		requires(Robot.in);
		this.liftType = liftType;
	}
	
    protected void initialize() {
    	System.out.println("-init Lift");

		// Nothing to initialize...

		System.out.println("-end-init Lift");
    }

    protected void execute() {
    	System.out.println("-exe Lift");
    	
    	switch(liftType) {
    	case 1:
    		Robot.lift.setSpeed(-0.02, 0.0);
    		break;
    	case 2:
    		Robot.lift.setSpeed(0.02, 0.02);
    		break;
    	}
    	
    	System.out.println("-end-exe Lift");
    }

    protected void end() {	
    	Robot.lift.setSpeed(0.0, 0.0);
    	
    	System.out.println("-end Lift");
    }
    
    protected void interrupted() {
    	end();
    }
    
    protected boolean isFinished() {
        return false;
    }
}
