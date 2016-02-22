package org.usfirst.frc.team4778.utils.conversions;

import edu.wpi.first.wpilibj.interfaces.Accelerometer;

/*
 * Defense Ramp Angle: 14.5 Degrees
 * Defense Ramp Width: 12 in.
 * Defense Ramp Length: 64 in.
 * 
 * Robot Width: 35 in.
 * Robot Length: 36.5 in
 */

//TODO Add Anti-Tipping Mechanism

public class AccToAngle {

	public static double getXRotation(Accelerometer acc) {
		return Math.toDegrees(Math.atan(acc.getX() / (Math.sqrt(Math.pow(acc.getY(), 2) + Math.pow(acc.getZ(), 2)))));
	}

	public static double getYRotation(Accelerometer acc) {
		return Math.toDegrees(Math.atan(acc.getY() / (Math.sqrt(Math.pow(acc.getX(), 2) + Math.pow(acc.getZ(), 2)))));
	}

	public static double getZRotation(Accelerometer acc) {
		return Math.toDegrees(Math.atan(Math.sqrt(Math.pow(acc.getX(), 2) + Math.pow(acc.getY(), 2)) / acc.getZ()));
	}
}