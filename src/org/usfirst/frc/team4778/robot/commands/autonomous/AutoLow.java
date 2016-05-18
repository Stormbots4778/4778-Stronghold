package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.commands.BallRoller;
import org.usfirst.frc.team4778.robot.commands.BreachLow;
import org.usfirst.frc.team4778.robot.commands.Delay;
import org.usfirst.frc.team4778.robot.commands.SetBallArm;

public class AutoLow extends Auto {

	public AutoLow(boolean shouldScore) {
		super(0, shouldScore);
	}
	
	public void runBreach() {
		System.out.println("-start low-bar breach");

		addSequential(new SetBallArm(false));
		addSequential(new BreachLow(-0.8));
		addSequential(new BallRoller(1));
		addSequential(new Delay(1000));
		addSequential(new BallRoller(0));
		addSequential(new BreachLow(0.8));
		addSequential(new SetBallArm(true));
		
		System.out.println("-end low-bar breach");
	}
}
