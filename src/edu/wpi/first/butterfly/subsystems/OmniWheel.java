/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.butterfly.subsystems;

import edu.wpi.first.butterfly.subsystems.Vector;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;

/**
 * Allows for packaging of repeated wheel code - For Omni drive only
 * @author Aditya
 */
public class OmniWheel {
    //private Talon t_controller;
    //private Victor v_controller;
    private Vector position;
    private Vector direction;
    
    /**
     * 
     * @param position  Represents the position of the wheel with respect to the center of the robot
     * @param direction Represents the direction that the wheel faces
     * @param controller Is the talon/victor that represents the motor controller
     */
    public OmniWheel(Vector position, Vector direction/*, Talon controller*/){
        this.position = position;
        this.direction = direction.normalize();
        
        //t_controller = controller;
        
        //v_controller = null;            //this wheel uses a talon controller
    }
    
    /**
     * 
     * @param position  Represents the position of the wheel with respect to the center of the robot
     * @param direction Represents the direction that the wheel faces
     * @param controller Is the talon/victor that represents the motor controller
     */
    /*
    public OmniWheel(Vector position, Vector direction, Victor controller){
        this.position = position;
        this.direction = direction.normalize();
        
        v_controller = controller;
        
        t_controller = null;            //this wheel uses a victor controller
    }*/
    
    
    public double getRequiredSpeed(Vector linear, Vector angular){
        Vector combinedSpeed = linear.add(angular.cross(position));     //find actual direction of the wheel taking into account
                                                                        // the rotational as well as linear motion
        
        return direction.dot(combinedSpeed);                            //finds the component of the velocity that the wheel can actually affect
        
    }
    
}
