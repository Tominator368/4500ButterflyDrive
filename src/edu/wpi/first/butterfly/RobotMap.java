package edu.wpi.first.butterfly;

import edu.wpi.first.butterfly.subsystems.Vector;

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
    
    
    public static final double gyroSensitivity = .007; // 7mV/degree/second
    
    public static Vector                      //TODO: need to actually measure and set this properly
            flWheelPosition = new Vector(-1, 1, 0),
            frWheelPosition = new Vector(1, 1, 0),
            blWheelPosition = new Vector(-1, -1, 0),
            brWheelPosition = new Vector(1, -1, 0),
            fmWheelPosition = new Vector(0, 1, 0),
            bmWheelPosition = new Vector(0, -1, 0);
    
    public static Vector                      //TODO: determine the actual directions that the wheels face particularly the fm and rm wheels
            flWheelDirection = new Vector(0, 1, 0),
            frWheelDirection = new Vector(0, 1, 0),
            blWheelDirection = new Vector(0, 1, 0),
            brWheelDirection = new Vector(0, 1, 0),
            fmWheelDirection = new Vector(-1, 0, 0),
            bmWheelDirection = new Vector(-1, 0, 0);

    
}
