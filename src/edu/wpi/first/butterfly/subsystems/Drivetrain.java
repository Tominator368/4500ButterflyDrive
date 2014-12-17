/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.butterfly.subsystems;

import edu.wpi.first.butterfly.RobotMap;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author IED
 */
public class Drivetrain extends Subsystem {
    
    Gyro roboGyro = new Gyro(RobotMap.gyroPort);
    
    Talon flMotor = new Talon(RobotMap.flMotorPort);
    Talon frMotor = new Talon(RobotMap.frMotorPort);
    Talon blMotor = new Talon(RobotMap.blMotorPort);
    Talon brMotor = new Talon(RobotMap.brMotorPort);
    Victor fmMotor = new Victor(RobotMap.fmMotorPort);
    Victor bmMotor = new Victor(RobotMap.bmMotorPort);
    
    
    
    private double forwardAngle; //Angle defined as being "forward" upon initializing the gyro
                                 //e.g. zeroing out the gyro
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    Vector robot = new Vector(0, 0, 0);
    

    public void initializeGyro() {
        roboGyro.setSensitivity(RobotMap.gyroSensitivity);
        forwardAngle = roboGyro.getAngle();
    }
    
    //Both left wheels and both right wheels will always go the same speed as far as I know
    public void setLeftSpeed(double speed) {
        flMotor.set(speed);
        blMotor.set(speed);
    }
    public void setRightSpeed(double speed) {
        frMotor.set(speed);
        brMotor.set(speed);
    }
    //The front and back ones aren't exactly necessary, I just put them in for consistancy
    public void setFrontSpeed(double speed) { 
        fmMotor.set(speed);
    }
    public void setBackSpeed(double speed) {
        bmMotor.set(speed);
    }
    
    public double getRobotFacingAngle(){
        return roboGyro.getAngle();
    }
    //All the vector crap using input from the joystick (oi.joyX, Y, and Z) goes here :)
    //Ultimately, this will use the setSpeed functions above to actually move the robot
    public void omniDrive() {
        
    }
    
    
    /**
     * Adjusts the angle defined as forward in case the gyro gets thrown off
     * 0 = adjust left 3 degrees
     * 1 = adjust right 3 degrees 
     * @param direction 
     */
    /*public void adjustForward(short direction) {
        switch(direction) {
            case 0:
                forwardAngle -= 3;
            case 1:
                forwardAngle += 3;
        }
    }
    */
    


//CONNER: Write stuff here
  
}
