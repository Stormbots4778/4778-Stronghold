package org.usfirst.frc.team4778.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class RobotMap {
	public static CameraServer camserver = CameraServer.getInstance();

	public static SendableChooser auto = new SendableChooser();

	// public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	//public static AnalogGyro gy2 = new AnalogGyro(0);

	public static Accelerometer acc = new BuiltInAccelerometer();

	public static Encoder leftdrive = new Encoder(0, 1, false, CounterBase.EncodingType.k4X);
	public static Encoder rightdrive = new Encoder(2, 3, false, CounterBase.EncodingType.k4X);

	public static int direction = 0;

	// TODO Please add a comment on what these are, Chase.
	public static double h = 0;
	public static double f = 0;
	public static int def = 0;
	public static int pos = 0;
}
