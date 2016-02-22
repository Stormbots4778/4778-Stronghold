package org.usfirst.frc.team4778.robot;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.vision.AxisCamera;

public class RobotMap {
	// Random variables ???
	public static double error = 0;
	public static boolean dir = true;
	
	// Gyro/Accelermoter
	public static AnalogGyro gyro = new AnalogGyro(0);
	public static Accelerometer acc = new BuiltInAccelerometer();
	
	// Encoders
	public static Encoder leftdrive = new Encoder(0, 1);
	public static Encoder rightdrive = new Encoder(2, 3);
	
	// Camera Stuff (Not sure if still going to be used)
	public static CameraServer camserver = CameraServer.getInstance();
	public static Image camimage = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
	public static AxisCamera camera = new AxisCamera("10.47.78.11");
	public static NetworkTable table;	
}
