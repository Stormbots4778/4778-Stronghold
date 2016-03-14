package org.usfirst.frc.team4778.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	public static Accelerometer acc = new BuiltInAccelerometer();
	public static Encoder leftdrive = new Encoder(0, 1);
	public static Encoder rightdrive = new Encoder(2, 3);
	public static CameraServer camserver = CameraServer.getInstance();
	public static boolean dir = true;
	public static double h = 0;
	public static double def = 0;
	public static double pos = 0;
	public static SendableChooser auto = new SendableChooser();
	public static SendableChooser autopos = new SendableChooser();
}
