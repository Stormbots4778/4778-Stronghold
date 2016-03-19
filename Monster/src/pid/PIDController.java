package pid;

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
	private double offset = 0;
	private double count = 0;

	public PIDController(double p, double i, double d, double setpoint) {
		kp = p;
		ki = i;
		kd = d;
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

	public void setOnTargetOffset(double value) {
		offset = value;
	}

	public boolean onTarget() {
		if (setpoint + offset > output || setpoint - offset < output) {
			count++;
		} else {
			count = 0;
		}
		if (count > 10) {
			return true;
		} else {
			return false;
		}
	}

	public double computePID(double in) {
		input = in;
		error = setpoint - input;
		inputDif = input - preInput;
		Iop = ki * error;
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
		return output;
	}

}
