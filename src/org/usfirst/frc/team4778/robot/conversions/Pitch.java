package org.usfirst.frc.team4778.robot.conversions;

import java.util.ArrayDeque;
import java.util.Queue;

import edu.wpi.first.wpilibj.interfaces.Accelerometer;

public class Pitch {
	Queue<Double> buf;
	double buftotal;
	double maxbuf = 1000;
	Accelerometer a;

	public Pitch(Accelerometer acc) {
		a = acc;
		buf = new ArrayDeque<Double>();
	}

	public double getP() {
		buf.add(Math.toDegrees(Math.atan(a.getY() / a.getZ())));
		buftotal += Math.toDegrees(Math.atan(a.getY() / a.getZ()));
		if (buf.size() > 100) {
			buftotal -= buf.remove();
		}
		return Math.toDegrees(Math.atan(a.getY() / a.getZ()));
	}

	public double getavP() {
		buf.add(Math.toDegrees(Math.atan(a.getY() / a.getZ())));
		buftotal += Math.toDegrees(Math.atan(a.getY() / a.getZ()));
		if (buf.size() > maxbuf) {
			buftotal -= buf.remove();
		}
		return buftotal / buf.size();
	}
}
