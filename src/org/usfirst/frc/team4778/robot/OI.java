package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.BallRoller;
import org.usfirst.frc.team4778.robot.commands.Lift;
import org.usfirst.frc.team4778.robot.commands.OISwitch;
import org.usfirst.frc.team4778.robot.commands.SetBallArm;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public static Joystick nip = new Joystick(3);
	
	public Joystick xbox = new Joystick(5);

	public static Button release = new JoystickButton(nip, 2);
	public static Button trap = new JoystickButton(nip, 3);
	public static Button up = new JoystickButton(nip, 5);
	public static Button down = new JoystickButton(nip, 6);
	public static Button manip = new JoystickButton(nip, 1);
	public static Button extend = new JoystickButton(nip, 0); //TODO figure out port
	public static Button retract = new JoystickButton(nip, 0); //TODO figure out port
	
	public OI() {
		System.out.println("-init OI");

		release.whileHeld(new BallRoller(-1)); // Releases the trapped ball
		trap.whileHeld(new BallRoller(1)); // Traps the ball
		up.whenPressed(new SetBallArm(true)); // Lift the ball-arm
		down.whenPressed(new SetBallArm(false)); // Lower the ball-arm
		manip.whileHeld(new OISwitch()); // sets the arm for the switch on the
		
		extend.whileHeld(new Lift(1));
		retract.whileHeld(new Lift(2));

		System.out.println("-end-init OI");
	}
}
