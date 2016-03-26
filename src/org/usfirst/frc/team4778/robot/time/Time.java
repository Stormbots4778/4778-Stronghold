package org.usfirst.frc.team4778.robot.time;

import edu.wpi.first.wpilibj.Timer;

public class Time {

	private static double time = 0;
	private static double endtime = 0;

	public static void delayMili(double miliseconds) {
		endtime = Timer.getFPGATimestamp() + miliseconds / 1000;
		while (time < endtime) {
			time = Timer.getFPGATimestamp();
		}
	}

	public static void delay(double seconds) {
		endtime = Timer.getFPGATimestamp() + seconds;
		while (time < endtime) {
			time = Timer.getFPGATimestamp();
		}
	}

}
