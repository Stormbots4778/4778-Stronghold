package org.usfirst.frc.team4778.robot;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.vision.AxisCamera;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static AnalogGyro gyro = new AnalogGyro(0);
	// public static Accelerometer acc = new BuiltInAccelerometer();
	public static CameraServer camserver = CameraServer.getInstance();
	public static double error = 0;
	public static NetworkTable table;
	public static Image camimage = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
	public static AxisCamera camera = new AxisCamera("10.47.78.11");

	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
