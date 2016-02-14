package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.Disrupt;
import org.usfirst.frc.team4778.robot.commands.GimMove;
import org.usfirst.frc.team4778.robot.commands.Shift;
import org.usfirst.frc.team4778.robot.commands.VisionTrack;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	public static Joystick joyleft = new Joystick(0);
	public static Joystick joyright = new Joystick(1);
	public static Button pid = new JoystickButton(joyleft, 6);
	public static Button calibrate = new JoystickButton(joyleft, 7);
	public static Button l = new JoystickButton(joyleft, 4);
	public static Button r = new JoystickButton(joyleft, 5);
	public static Button d = new JoystickButton(joyleft, 2);
	public static Button u = new JoystickButton(joyleft, 3);
	public static Button t = new JoystickButton(joyright, 10);
	public static Button shiftIn = new JoystickButton(joyright, 4);
	public static Button shiftOut = new JoystickButton(joyright, 5);

	public OI() {
		pid.whileHeld(new Disrupt(true, 0));
		calibrate.whileHeld(new Disrupt(false, 0));
		l.whenPressed(new GimMove(0, -10));
		r.whenPressed(new GimMove(0, 10));
		u.whenPressed(new GimMove(-10, 0));
		d.whenPressed(new GimMove(10, 0));
		t.whileHeld(new VisionTrack());
		shiftIn.whileHeld(new Shift(true));
		shiftOut.whileHeld(new Shift(false));
	}
}
