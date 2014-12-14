/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.butterfly.subsystems;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author IED
 */
public class Drivetrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    //CONNER: Write stuff here
    
    
    
    /**
     * Vector functions for the omnidrive drivetrain
     */
    public class Vector {
	public final Vector zero = new Vector(0,0,0);
	
	private double x,y,z;
	
	/**
	 * Returns the X component of the vector.
	 * @return
	 */
	public double getX(){
		return x;
	}
	
	/**
	 * Returns the Y component of the vector.
	 * @return
	 */
	public double getY(){
		return y;
	}
	
	/**
	 * Returns the Z component of the vector
	 * @return
	 */
	public double getZ(){
		return z;
	}
	
	/**
	 * Constructor for vector <x, y, z>
	 * @param x
	 * @param y
	 * @param z
	 */
	public Vector(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
		
	}
	
	/**
	 * Adds two vectors together and returns the result.
	 * @param other
	 * @return
	 */
	public Vector add(Vector other){
		return new Vector(x+other.x, y+other.y, z+other.z);
	}
	
	/**
	 * Subtracts other from this vector and returns the result.
	 * @param other
	 * @return
	 */
	public Vector subtract(Vector other){
		return new Vector(x-other.x, y-other.y, z-other.z);
	}
	
	/**
	 * Finds the dot product of this vector and the other vector.
	 * @param other
	 * @return
	 */
	public double dot(Vector other){
		return x*other.x + y*other.y + z*other.z;
	}
	
	/**
	 * Returns the cross product of this vector and the other vector in that order.
	 * @param other
	 * @return
	 */
	public Vector cross(Vector other){
		return new Vector(
				y*other.z - z*other.y,
				z*other.x - x*other.z,
				x*other.y - y*other.x
				);
	}
	
	/**
	 * Returns the magnitude of the vector,
	 * @return
	 */
	public double magnitude(){
		return Math.sqrt(x*x + y*y + z*z);
	}
	
	/**
	 * Returns the magnitude squared of the vector.
	 * @return
	 */
	public double magnitudeSquared(){
		return x*x + y*y + z*z;
	}
	
	/**
	 * Returns a unit vector pointing in the direction of this vector.
	 * @return
	 */
	public Vector normalize(){
		double mag = magnitude();
		return new Vector(x/mag, y/mag, z/mag);
	}
	
	/**
	 * Returns true if this vector equals the other vector, otherwise it returns false.
	 * @param other
	 * @return
	 */
	public boolean equals(Vector other){
		return x == other.x && y == other.y && z == other.z;
	}
	
	/**
	 * Returns this vector scaled by a scale factor.
	 * @param factor
	 * @return
	 */
	public Vector scale(double factor){
		return new Vector(x*factor, y*factor, z*factor);
	}
	
	/**
	 * Rotates the vector about the Z axis theta radians with positive 
	 * being counterclockwise looking down onto the vector (in the -Z direction)
	 * @param theta
	 * @return
	 */
	public Vector rotateAboutZAxis(double theta){
		double newX = x*Math.cos(theta) - y*Math.sin(theta);
		double newY = x*Math.sin(theta) + y*Math.cos(theta);
		
		return new Vector(newX, newY, z);
		
		
	}

	/**
	 * Returns the smallest angle between this vector and the other vector
	 * @param other
         * @return 
	 */
	public double getAngleBetween(Vector other){
		return MathUtils.acos(dot(other)/(magnitude() * other.magnitude()));
	}
	
        /**
         * This is a function to replace java.lang.Math.signum because it 
         * doesn't work in the FRC package.
         * @param f
         * @return 
         */
        public double signum(double  f) {
            if (f > 0) {
                return 1.0;
            }
            if (f < 0) {
                return -1.0;
            }
            else {
                return 0.0;
            }
        }
        
	/**
	 * Returns the counterclockwise angle between this vector and the other vector
	 * in the range -pi(exclusive) to pi(inclusive) as seen from above the origin or as looking down on the robot.
	 * @param other
	 * @return
	 */
	public double getCounterclockwiseAngleBetween(Vector other){
		double sign = signum(cross(other).getZ()); //the sign of the cross product - will be zero if the vectors are paralell
		
		if(sign!=0){
			return  sign*getAngleBetween(other);
		}else{
			return getAngleBetween(other);
		}
	}
	
	public String toString(){
		return "<"+x+", "+y+", "+z+">";
	}
	
	
	
}
}
