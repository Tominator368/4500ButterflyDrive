/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.butterfly;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.butterfly.commands.CommandBase;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class ButterflyMain extends IterativeRobot {

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        //autonomousCommand = new ExampleCommand();

        // Initialize all subsystems
        CommandBase.init();
        
        double [] lengths = {
            RobotMap.flWheelPosition.magnitude(),  
            RobotMap.frWheelPosition.magnitude(),  
            RobotMap.blWheelPosition.magnitude(),  
            RobotMap.brWheelPosition.magnitude(),  
            RobotMap.fmWheelPosition.magnitude(),  
            RobotMap.bmWheelPosition.magnitude()
        };
        double maximumLength = 0;
        for(int i = 0;i<lengths.length;i++){
            maximumLength = Math.max(maximumLength, lengths[i]);
        }
        
        RobotMap.flWheelPosition = RobotMap.flWheelPosition.scale(1/maximumLength);
        RobotMap.frWheelPosition = RobotMap.frWheelPosition.scale(1/maximumLength);
        RobotMap.blWheelPosition = RobotMap.blWheelPosition.scale(1/maximumLength);
        RobotMap.brWheelPosition = RobotMap.brWheelPosition.scale(1/maximumLength);
        RobotMap.fmWheelPosition = RobotMap.fmWheelPosition.scale(1/maximumLength);
        RobotMap.bmWheelPosition = RobotMap.bmWheelPosition.scale(1/maximumLength);
        
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
