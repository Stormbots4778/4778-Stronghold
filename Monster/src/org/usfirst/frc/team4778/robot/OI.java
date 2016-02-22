package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.BallToggle;
import org.usfirst.frc.team4778.robot.commands.LiftToggle;
import org.usfirst.frc.team4778.robot.commands.ReleaseBall;
import org.usfirst.frc.team4778.robot.commands.Reverse;
import org.usfirst.frc.team4778.robot.commands.ShiftToggle;
import org.usfirst.frc.team4778.robot.commands.TestPID;
import org.usfirst.frc.team4778.robot.commands.TrapBall;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public static Joystick joyleft = new Joystick(0);
	public static Joystick joyright = new Joystick(1);
	public static Button testpid = new JoystickButton(joyleft, 6);
	public static Button calibrategyro = new JoystickButton(joyleft, 7);
	public static Button l = new JoystickButton(joyleft, 4);
	public static Button r = new JoystickButton(joyleft, 5);
	public static Button d = new JoystickButton(joyleft, 2);
	public static Button u = new JoystickButton(joyleft, 3);
	public static Button shift = new JoystickButton(joyright, 4);
	public static Button release = new JoystickButton(joyright, 1);
	public static Button trap = new JoystickButton(joyleft, 1);
	public static Button ballarm = new JoystickButton(joyright, 2);
	public static Button arm = new JoystickButton(joyright, 3);
	public static Button swich = new JoystickButton(joyright, 5);

	public OI() {
		System.out.println("OI");
		testpid.whileHeld(new TestPID(false));
		calibrategyro.whileHeld(new TestPID(true));
		swich.whenPressed(new Reverse());
		// l.whenPressed(new GimMove(0, -10));
		// r.whenPressed(new GimMove(0, 10));
		// u.whenPressed(new GimMove(-10, 0));
		// d.whenPressed(new GimMove(10, 0));
		release.whileHeld(new ReleaseBall());
		trap.whileHeld(new TrapBall());
		shift.whileHeld(new ShiftToggle());
		arm.whileHeld(new LiftToggle());
		ballarm.whileHeld(new BallToggle());
	}
}
