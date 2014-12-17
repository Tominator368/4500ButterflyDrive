
package edu.wpi.first.butterfly;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    
    Joystick driveStick = new Joystick(1);
    
    Button b1 = new JoystickButton(driveStick, 1),
            b2 = new JoystickButton(driveStick, 2);
  
    public double joyX() {
        return driveStick.getX();
    }
    
    public double joyY() {
        return driveStick.getY();
    }
    
    public double joyZ() {
        return driveStick.getZ();
    }
    
    public OI() {
        
    }
}

