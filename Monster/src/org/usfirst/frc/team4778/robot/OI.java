package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.ReleaseBall;
import org.usfirst.frc.team4778.robot.commands.SetBallArm;
import org.usfirst.frc.team4778.robot.commands.SetShifting;
import org.usfirst.frc.team4778.robot.commands.TestPID;
import org.usfirst.frc.team4778.robot.commands.TrapBall;

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
	public static Joystick gamepad = new Joystick(2);
	public static Button testpid = new JoystickButton(joyleft, 6);
	public static Button calibrategyro = new JoystickButton(joyleft, 7);
	public static Button l = new JoystickButton(joyleft, 4);
	public static Button r = new JoystickButton(joyleft, 5);
	public static Button d = new JoystickButton(joyleft, 2);
	public static Button u = new JoystickButton(joyleft, 3);
	public static Button shift = new JoystickButton(joyright, 4);
	public static Button release = new JoystickButton(joyleft, 3);
	public static Button trap = new JoystickButton(joyleft, 2);
	public static Button ballarm = new JoystickButton(joyright, 2);
	public static Button arm = new JoystickButton(joyright, 3);
	public static Button swich = new JoystickButton(joyright, 5);
	public static Button ballup = new JoystickButton(joyright, 3);
	public static Button balldown = new JoystickButton(joyright, 2);
	public static Button shiftout = new JoystickButton(joyright, 5);
	public static Button shiftin = new JoystickButton(joyright, 4);
	public static Button up = new JoystickButton(gamepad, 6);
	public static Button down = new JoystickButton(gamepad, 5);
	public static Button in = new JoystickButton(gamepad, 1);
	public static Button out = new JoystickButton(gamepad, 4);

	public OI() {
		System.out.println("OI");
		testpid.whileHeld(new TestPID(false));
		calibrategyro.whileHeld(new TestPID(true));
		// swich.whenPressed(new Reverse());
		// l.whenPressed(new GimMove(0, -10));
		// r.whenPressed(new GimMove(0, 10));
		// u.whenPressed(new GimMove(-10, 0));
		// d.whenPressed(new GimMove(10, 0));
		release.whileHeld(new ReleaseBall());
		trap.whileHeld(new TrapBall());
		shiftin.whenPressed(new SetShifting(true));
		shiftout.whenPressed(new SetShifting(false));
		ballup.whenPressed(new SetBallArm(true));
		ballup.whenPressed(new SetBallArm(false));
		up.whileHeld(new SetBallArm(true));
		down.whileHeld(new SetBallArm(false));
		in.whileHeld(new TrapBall());
		out.whileHeld(new ReleaseBall());
		// shift.whenPressed(new ShiftToggle());
		// arm.whenPressed(new LiftToggle());
		// ballarm.whenPressed(new BallToggle());
	}
}
