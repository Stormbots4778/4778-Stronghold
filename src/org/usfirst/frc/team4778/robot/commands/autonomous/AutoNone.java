package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.commands.SetBallArm;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoNone extends CommandGroup {

	public AutoNone() {
		addSequential(new SetBallArm(true));
		System.out.println("No Auto");
	}
}
