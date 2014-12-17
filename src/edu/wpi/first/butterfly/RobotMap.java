package edu.wpi.first.butterfly;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
    //Sidecar motor ports
    public static final int
            flMotorPort = 1,
            frMotorPort = 2,
            blMotorPort = 3,
            brMotorPort = 4,
            fmMotorPort = 5,
            bmMotorPort = 6;
    
    //Analog breakout ports
    public static final int
            gyroPort = 1;
    
    
    public static final double gyroSensitivity = 1; //To be set per the instructions on the gyro

}
