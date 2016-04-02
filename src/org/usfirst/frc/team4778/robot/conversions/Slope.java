package org.usfirst.frc.team4778.robot.conversions;

import java.util.LinkedList;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Timer;

public class Slope {
	LinkedList<Double> buf;
	LinkedList<Double> time;
	double maxbuf = 1000;
	double offset;
	AHRS ahrs;
	
	public Slope(AHRS ahrs) {
		buf = new LinkedList<Double>();
		time = new LinkedList<Double>();
		offset = Timer.getFPGATimestamp();
		this.ahrs = ahrs;
	}
	
	public double getSlope() {
		buf.add((double)ahrs.getPitch());
		time.add(Timer.getFPGATimestamp()-offset);
		if (buf.size() > maxbuf) {
			buf.remove();
			time.remove();
		}
		return((buf.getLast()-buf.getFirst())/(time.getLast()-time.getFirst()));
	}
}
