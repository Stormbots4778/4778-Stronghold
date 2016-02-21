package conversions;

import edu.wpi.first.wpilibj.interfaces.Accelerometer;

/*
 * Defense Ramp Angle: 14.5 Degrees
 * Defense Ramp Width: 12 in.
 * Defense Ramp Length: 64 in.
 */

//TODO Add Anti-Tipping Mechanism

public class AccToAngle {

	Accelerometer acc;

	public AccToAngle(Accelerometer a) {
		acc = a;
	}

	public double getXRotation() {
		return Math.toDegrees(Math.atan(acc.getX() / (Math.sqrt(Math.pow(acc.getY(), 2) + Math.pow(acc.getZ(), 2)))));
	}

	public double getYRotation() {
		return Math.toDegrees(Math.atan(acc.getY() / (Math.sqrt(Math.pow(acc.getX(), 2) + Math.pow(acc.getZ(), 2)))));
	}

	public double getZRotation() {
		return Math.toDegrees(Math.atan(Math.sqrt(Math.pow(acc.getX(), 2) + Math.pow(acc.getY(), 2)) / acc.getZ()));
	}
}