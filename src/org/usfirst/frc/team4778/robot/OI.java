package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.BallRoller;
import org.usfirst.frc.team4778.robot.commands.OISwitch;
import org.usfirst.frc.team4778.robot.commands.SetBallArm;
import org.usfirst.frc.team4778.robot.commands.SetShifting;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public static Joystick joyleft = new Joystick(0);
	public static Joystick joyright = new Joystick(1);
	
	public static Joystick nip = new Joystick(3);
	public static Joystick gamepad = new Joystick(2);
	
	public static Button grelease = new JoystickButton(gamepad, 3);
	public static Button release = new JoystickButton(nip, 2);
	public static Button trap = new JoystickButton(nip, 3);
	public static Button gtrap = new JoystickButton(gamepad, 2);
	public static Button up = new JoystickButton(nip, 5);
	public static Button gup = new JoystickButton(gamepad, 6);
	public static Button down = new JoystickButton(nip, 6);
	public static Button gdown = new JoystickButton(gamepad, 7);
	public static Button manip = new JoystickButton(nip, 1);
	
	public static Button in = new JoystickButton(joyleft, 1);
	public static Button out = new JoystickButton(joyright, 1);

	public OI() {
		System.out.println("-init OI");
		
		release.whileHeld(new BallRoller(-1));		// Releases the trapped ball
		grelease.whileHeld(new BallRoller(-1));		// Releases the trapped ball
		
		trap.whileHeld(new BallRoller(1));			// Traps the ball
		gtrap.whileHeld(new BallRoller(1));			// Traps the ball
		
		up.whenPressed(new SetBallArm(true));		// Lift the ball-arm
		down.whenPressed(new SetBallArm(false));	// Lower the ball-arm
		in.whenPressed(new SetShifting(true));		// Shift in
		out.whenPressed(new SetShifting(false));	// Shift out
		manip.whileHeld(new OISwitch());			// TODO Explain this please, Chase
		gup.whenPressed(new SetBallArm(true));		
		gdown.whenPressed(new SetBallArm(false));	
		
		System.out.println("-end-init OI");
	}
}
