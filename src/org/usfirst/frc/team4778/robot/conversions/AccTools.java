package org.usfirst.frc.team4778.robot.conversions;

import java.util.ArrayDeque;
import java.util.Queue;

import edu.wpi.first.wpilibj.interfaces.Accelerometer;

public class AccTools {

	Accelerometer acc;
	AccToAngle ata;
	double x, y, z, bufsize = 100000, thr, bufxt, bufyt, bufzt;
	Queue<Double> bufx;
	Queue<Double> bufy;
	Queue<Double> bufz;

	public AccTools(Accelerometer a) {
		bufx = new ArrayDeque<Double>();
		bufy = new ArrayDeque<Double>();
		bufz = new ArrayDeque<Double>();
		ata = new AccToAngle(a);
	}

	public double getX() {
		bufx.add(ata.getXRotation());
		bufxt += ata.getXRotation();
		if (bufx.size() > bufsize) {
			bufxt -= bufx.remove();
		}
		return bufxt / bufx.size();
	}

	public double getY() {
		double result = Math.toDegrees(Math.atan(acc.getY() / acc.getZ()));
		return result;
	}

	public double getZ() {
		bufz.add(ata.getZRotation());
		bufzt += ata.getZRotation();
		if (bufz.size() > bufsize) {
			bufzt -= bufz.remove();
		}
		return bufzt / bufz.size();
	}

	public void update() {
		bufx.add(ata.getXRotation());
		bufxt += ata.getXRotation();
		if (bufx.size() > bufsize) {
			bufxt -= bufx.remove();
		}
		bufy.add(ata.getYRotation());
		bufyt += ata.getYRotation();
		if (bufy.size() > bufsize) {
			bufyt -= bufy.remove();
		}
		bufz.add(ata.getZRotation());
		bufzt += ata.getZRotation();
		if (bufz.size() > bufsize) {
			bufzt -= bufz.remove();
		}
	}

	public void setFlatThreshold(double value) {
		thr = value;
	}

	public boolean Flat() {
		return bufz.size() > 0 && bufzt / bufz.size() < thr;
	}

}
