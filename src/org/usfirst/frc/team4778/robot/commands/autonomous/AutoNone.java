package org.usfirst.frc.team4778.robot.commands.autonomous;

import org.usfirst.frc.team4778.robot.commands.Delay;
import org.usfirst.frc.team4778.robot.commands.DriveForward;
import org.usfirst.frc.team4778.robot.commands.SetBallArm;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoNone extends CommandGroup {

	public AutoNone() {
		addSequential(new SetBallArm(true));
		addSequential(new DriveForward(5));
		addSequential(new Delay(500));
		addSequential(new DriveForward(0));
		System.out.println("No Auto");
	}
}
