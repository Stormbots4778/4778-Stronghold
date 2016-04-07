package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.BallRoller;
import org.usfirst.frc.team4778.robot.commands.Illuminate;
import org.usfirst.frc.team4778.robot.commands.Lift;
import org.usfirst.frc.team4778.robot.commands.OISwitch;
import org.usfirst.frc.team4778.robot.commands.SetBallArm;
import org.usfirst.frc.team4778.robot.commands.SetShifting;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public static Joystick nip = new Joystick(3);
	public static Joystick xbox = new Joystick(5);
	
	public static Button release = new JoystickButton(nip, 2);
	public static Button trap = new JoystickButton(nip, 3);
	
	public static Button up = new JoystickButton(nip, 5);
	public static Button down = new JoystickButton(nip, 6);
	public static Button manip = new JoystickButton(nip, 1);
	
	public static Button extend = new JoystickButton(nip, 5); //TODO figure out port
	public static Button retract = new JoystickButton(nip, 4); //TODO figure out port
	
	public static Button shift = new JoystickButton(xbox, 5);
	public static Button light = new JoystickButton(xbox, 4);
	
	public OI() {
		System.out.println("-init OI");	
		
		shift.whileActive(new SetShifting(true));
		shift.whenInactive(new SetShifting(false));
		light.whenPressed(new Illuminate(!RobotMap.lightIsOn));
		
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