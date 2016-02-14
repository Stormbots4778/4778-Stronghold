package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinRoller extends Command {

    public SpinRoller(int direction) {
    	requires(Robot.ballMech);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.ballMech.spinRoller();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {

    }

    protected void interrupted() {
    	end();
    }
}
