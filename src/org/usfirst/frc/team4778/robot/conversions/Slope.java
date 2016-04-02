package org.usfirst.frc.team4778.robot.conversions;

import java.util.LinkedList;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

public class Slope {
	LinkedList<Double> buf;
	LinkedList<Double> time;
	double maxbuf = 1000;
	double offset;
	Pitch pitch;
	
	public Slope(Accelerometer a) {
		buf = new LinkedList<Double>();
		time = new LinkedList<Double>();
		offset = Timer.getFPGATimestamp();
		pitch = new Pitch(a);
	}
	
	public double getSlope() {
		buf.add(pitch.getP());
		time.add(Timer.getFPGATimestamp()-offset);
		if (buf.size() > maxbuf) {
			buf.remove();
			time.remove();
		}
		return((buf.getLast()-buf.getFirst())/(time.getLast()-time.getFirst()));
	}
}
