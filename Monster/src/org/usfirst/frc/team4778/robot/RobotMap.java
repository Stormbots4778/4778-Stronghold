package org.usfirst.frc.team4778.robot;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.vision.AxisCamera;

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
	public static Object autonomous = new Object();
	public static NetworkTable table;
	public static SendableChooser auto = new SendableChooser();
	public static Image camimage = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
	public static AxisCamera camera = new AxisCamera("10.47.78.11");
	public static PowerDistributionPanel pdp = new PowerDistributionPanel();
	public static SendableChooser autopos = new SendableChooser();

	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
