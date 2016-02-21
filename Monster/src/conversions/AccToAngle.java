package conversions;

import edu.wpi.first.wpilibj.interfaces.Accelerometer;

public class AccToAngle {

	Accelerometer acc;

	public AccToAngle(Accelerometer a) {
		acc = a;
	}

	public double getXRotation() {
		double angX = Math.atan(acc.getX() / (Math.sqrt(Math.pow(acc.getY(), 2) + Math.pow(acc.getZ(), 2))));
		return Math.toDegrees(angX);
	}

	public double getYRotation() {
		double angY = Math.atan(acc.getY() / (Math.sqrt(Math.pow(acc.getX(), 2) + Math.pow(acc.getZ(), 2))));
		return Math.toDegrees(angY);
	}

	public double getZRotation() {
		double angZ = Math.atan(Math.sqrt(Math.pow(acc.getX(), 2) + Math.pow(acc.getY(), 2)) / acc.getZ());
		return Math.toDegrees(angZ);
	}
}
