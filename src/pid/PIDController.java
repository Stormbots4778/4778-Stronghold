package pid;

import java.util.ArrayDeque;
import java.util.Queue;

public class PIDController {

	private double kp = 0;
	private double ki = 0;
	private double kd = 0;
	private double setpoint = 0;
	private double preInput = 0;
	private double input = 0;
	private double output = 0;
	private double error = 0;
	private double inputDif = 0;
	private double outMax = 0;
	private double outMin = 0;
	private double Iop = 0;
	private double tol = 2;
	private double bufLength = 1;
	private double bufTotal = 0;
	private Queue<Double> buf;

	public PIDController(double p, double i, double d, double s) {
		kp = p;
		ki = i;
		kd = d;
		setpoint = s;
		buf = new ArrayDeque<Double>();
	}

	public void setTunings(double p, double i, double d) {
		kp = p;
		ki = i;
		kd = d;
	}

	public void setSetpoint(double value) {
		setpoint = value;
	}

	public void setOutputLimits(double min, double max) {
		outMax = max;
		outMin = min;
	}

	public void setTolerence(double value) {
		tol = value;
	}

	public boolean onTarget() {
		return buf.size() > 0 && Math.abs(bufTotal / buf.size()) < tol;

	}

	public double computePID(double in) {
		input = in;
		error = setpoint - input;
		inputDif = input - preInput;
		Iop += ki * error;
		if (Iop > outMax) {
			Iop = outMax;
		}
		output = kp * error + Iop - kd * inputDif;
		preInput = input;
		if (output > outMax) {
			output = outMax;
		} else if (output < outMin) {
			output = outMin;
		}
		bufTotal += error;
		buf.add(error);
		if (buf.size() > bufLength) {
			bufTotal -= buf.remove();
		}
		return output;
	}

	public double getSetpoint() {
		return setpoint;
	}

	public double getKd() {
		return kd;
	}

	public double getKi() {
		return ki;
	}

	public double getKp() {
		return kp;
	}

}
