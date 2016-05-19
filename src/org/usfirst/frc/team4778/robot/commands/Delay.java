package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Delay extends Command {

	double endtime;
	double time;
	boolean finish = false;

	public Delay(double val) {
		time = val / 1000;
	}

	protected void initialize() {
		System.out.println("-init Delay");
		
		endtime = Timer.getMatchTime() + time;
		
		System.out.println("-end-init Delay");
	}
	
	protected void execute() {
		System.out.println("-exe Delay");

		if (Timer.getMatchTime() > endtime) {
			finish = true;
		}
		
		System.out.println("-end-exe Delay");
	}

	protected boolean isFinished() {
		return finish;
	}

	protected void end() {
		
	}

	protected void interrupted() {
		end();
	}
}
