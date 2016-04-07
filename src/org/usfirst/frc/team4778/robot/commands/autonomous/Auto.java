package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.commands.BallRoller;
import org.usfirst.frc.team4778.robot.commands.Delay;
import org.usfirst.frc.team4778.robot.commands.Move;
import org.usfirst.frc.team4778.robot.commands.SetBallArm;
import org.usfirst.frc.team4778.robot.commands.TurnToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auto extends CommandGroup {
    
    public  Auto(int defenseId, boolean shouldScore) {
    	init();
    	runBreach();
    	if(shouldScore) {
    		runScore(defenseId);
    	}
    }
    
    public void init() { // Initialization code goes here
    	System.out.println("-init Auto");
    	
		RobotMap.ahrs.reset();
		RobotMap.ahrs.resetDisplacement();
		RobotMap.leftdrive.reset();
		RobotMap.rightdrive.reset();
		
    	System.out.println("-end-init Auto");
    }
    
    public void runBreach() {
    	
    	// Defense crossing code goes here
    
    }
    
    public void runScore(int defenseId) {
    	// Scoring code goes here
    	
		switch (defenseId) {
		case 0:
			addSequential(new SetBallArm(true));
			addSequential(new TurnToAngle(59));
			addSequential(new Move(135.5));
			addSequential(new SetBallArm(false));
			addSequential(new Delay(750));
			addSequential(new BallRoller(-1), 2);
		case 1:
			addSequential(new Move(138));
			addSequential(new TurnToAngle(59));
			addSequential(new Move(74));
			addParallel(new SetBallArm(true));
			addSequential(new BallRoller(-1), 2000);
			break;
		case 2:
			addSequential(new Move(17));
			addSequential(new TurnToAngle(-31));
			addSequential(new Move(112));
			addSequential(new TurnToAngle(59));
			addSequential(new Move(74));
			addParallel(new SetBallArm(true));
			addSequential(new BallRoller(-1), 2000);
			break;
		case 3:
			addSequential(new Move(70));
			addSequential(new TurnToAngle(33));
			addSequential(new Move(98));
			addSequential(new TurnToAngle(-57));
			addSequential(new Move(41));
			addParallel(new SetBallArm(true));
			addSequential(new BallRoller(-1), 2000);
			break;
		case 4:
			addSequential(new Move(153));
			addSequential(new TurnToAngle(59));
			addSequential(new Move(41));
			addParallel(new SetBallArm(true));
			addSequential(new BallRoller(-1), 2000);
			break;
		}
    }
}
