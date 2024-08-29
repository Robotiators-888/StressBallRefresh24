
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

        //Drive Motors
        public static final int ID_LEFT_PRIMARY = 22;  
        public static final int ID_LEFT_SECONDARY = 23;  
        public static final int ID_RIGHT_PRIMARY = 20;  
        public static final int ID_RIGHT_SECONDARY = 21;  

        //Speed for the motors
        public static final Double speed = 0.6;
        

        //Joystick
        //this tells which port of the driver station the joystick is in
        public static final int JOYSTICK_PORT = 0;  
        
        //This tells us which part of the joystick will be used
        // 1 = to the left stick's y axis
        public static final int LEFT_AXIS = 1; 
        // 4 = to the right stick's y axis 
        public static final int RIGHT_AXIS = 4;  
        // 1 = the a button on joystick
        public static final int A_BUTTON = 1;
        // 2 = the b button on joystick
        public static final int B_BUTTON = 2;
        // 5 = the up on the d pad
        public static final int DAPD_UP = 5;
        // 6 = down on the d pad
        public static final int DAPD_DOWN = 6;
    

        //Shooter
        public static final int FLYWHEEL_LEFT = 0;
        public static final int FLYWHEEL_RIGHT = 1;
        public static final int ELEVATION = 2;
        
        public static final double FLYWHEEL_SPEED = .5;
        public static final double ELEVATION_SPEED = 0.5;
		public static final int RIGHT_TRIGGER = 3;
    
}

