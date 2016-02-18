package arduino;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;

public class IO {

	private static DigitalInput sonar = new DigitalInput(0);
	private static DigitalInput gx = new DigitalInput(1);
	private static DigitalInput gy = new DigitalInput(2);
	private static DigitalInput gz = new DigitalInput(3);

	public IO() {
	}

	public double getsonar() {
		double time = 0;
		if (sonar.get() == true) {
			double s = Timer.getFPGATimestamp();
			while (sonar.get() == true)
				;
			double e = Timer.getFPGATimestamp();
			time = e - s;
			return time;
		} else {
			return 0;
		}
	}
	public double getgz() {
		double time = 0;
		if (gz.get() == true) {
			double s = Timer.getFPGATimestamp();
			while (gz.get() == true)
				;
			double e = Timer.getFPGATimestamp();
			time = e - s;
			return time;
		} else {
			return 0;
		}
	}
	public double getgy() {
		double time = 0;
		if (gy.get() == true) {
			double s = Timer.getFPGATimestamp();
			while (gy.get() == true)
				;
			double e = Timer.getFPGATimestamp();
			time = e - s;
			return time;
		} else {
			return 0;
		}
	}
	public double getgx() {
		double time = 0;
		if (gx.get() == true) {
			double s = Timer.getFPGATimestamp();
			while (gx.get() == true)
				;
			double e = Timer.getFPGATimestamp();
			time = e - s;
			return time;
		} else {
			return 0;
		}
	}
	
}
