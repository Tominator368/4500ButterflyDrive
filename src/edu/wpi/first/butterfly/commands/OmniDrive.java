/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.butterfly.commands;

import edu.wpi.first.butterfly.OmniWheel;
import edu.wpi.first.butterfly.RobotMap;
import edu.wpi.first.butterfly.subsystems.Vector;

/**
 *
 * @author IED
 */
public class OmniDrive extends CommandBase {
    
    
    OmniWheel flWheel = new OmniWheel(RobotMap.flWheelPosition, RobotMap.flWheelDirection);
    OmniWheel frWheel = new OmniWheel(RobotMap.frWheelPosition, RobotMap.frWheelDirection);
    OmniWheel blWheel = new OmniWheel(RobotMap.blWheelPosition, RobotMap.blWheelDirection);
    OmniWheel brWheel = new OmniWheel(RobotMap.brWheelPosition, RobotMap.brWheelDirection);
    OmniWheel fmWheel = new OmniWheel(RobotMap.fmWheelPosition, RobotMap.fmWheelDirection);
    OmniWheel bmWheel = new OmniWheel(RobotMap.bmWheelPosition, RobotMap.bmWheelDirection);

    public OmniDrive() {
        requires(drivetrain);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        drivetrain.initializeGyro();
        
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Vector linear = new Vector(oi.joyX(), oi.joyY(), 0);
        
        
        //temporarily removed gyro stuff while i check if it is in degrees or radians
        /*double angle = drivetrain.getRobotFacingAngle();
        
        linear = linear.rotateAboutZAxis(-angle);               //convert the angle of the input to the angle in the robot reference frame
        */
        Vector angular = new Vector(0, 0, oi.joyZ());
        
        drivetrain.setLeftSpeed(flWheel.getRequiredSpeed(linear, angular));     //sets all the speeds I think that the two wheels don't matter?
        drivetrain.setRightSpeed(frWheel.getRequiredSpeed(linear, angular));
        drivetrain.setFrontSpeed(fmWheel.getRequiredSpeed(linear, angular));
        drivetrain.setBackSpeed(bmWheel.getRequiredSpeed(linear, angular));
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
