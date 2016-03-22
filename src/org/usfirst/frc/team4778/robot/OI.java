package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.ReleaseBall;
import org.usfirst.frc.team4778.robot.commands.SetBallArm;
import org.usfirst.frc.team4778.robot.commands.SetShifting;
import org.usfirst.frc.team4778.robot.commands.OISwitch;
import org.usfirst.frc.team4778.robot.commands.TrapBall;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static Joystick joyleft = new Joystick(0);
	public static Joystick joyright = new Joystick(1);
	public static Joystick nip = new Joystick(3);
	public static Joystick gamepad = new Joystick(2);
	public static Button release = new JoystickButton(nip, 3);
	public static Button trap = new JoystickButton(nip, 2);
	public static Button up = new JoystickButton(nip, 5);
	public static Button down = new JoystickButton(nip, 6);
	public static Button manip = new JoystickButton(nip, 1);
	public static Button in = new JoystickButton(joyright, 4);
	public static Button out = new JoystickButton(joyright, 5);

	public OI() {
		System.out.println("OI");
		release.whileHeld(new ReleaseBall());
		trap.whileHeld(new TrapBall());
		up.whenPressed(new SetBallArm(true));
		down.whenPressed(new SetBallArm(false));
		in.whenPressed(new SetShifting(true));
		out.whenPressed(new SetShifting(false));
		manip.whileHeld(new OISwitch());
	}
}
