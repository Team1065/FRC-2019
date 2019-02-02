/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  //PID Constants
  public static final double MECANUM_STRAIGHT_DRIVE_P = 0.023;
  //Double Constants
  public static final double JOYSTICK_DEADBAND = 0.05,
                              DRIVE_STRAIGHT_BAND_PERCENTAGE = 0.25,
                              DRIVE_WHEEL_DIAMETER = 6,
                              DRIVE_ENCODERS_COUNTS_PER_REV = 20;

  //PWM Ports
  public static final int LEFT_FRONT_DRIVE_MOTOR_PORT = 0,
                          RIGHT_FRONT_DRIVE_MOTOR_PORT = 1,
                          LEFT_BACK_DRIVE_MOTOR_PORT = 2,
                          RIGHT_BACK_DRIVE_MOTOR_PORT = 3;

 //CAN Ports
  public static final int INTAKE_VICTOR_PORT = 1,
                          INDEXER_MID_VICTOR_PORT = 2,
                          INDEXER_TOP_VICTOR_PORT = 3,
                          SHOOTER_VICTOR_PORT = 4;

  //PCM Ports
  public static final int DROPDOWN_SOLENOID_PORT = 1;

  //Digital Ports
  public static final int DRIVE_ENCODER_PORT_A = 0,
                          DRIVE_ENCODER_PORT_B = 1;

  //OI
  public static final int LEFT_JOYSTICK_PORT = 0,					//usb
                          RIGHT_JOYSTICK_PORT = 1,				//usb
                          ENHANCED_DS_PORT = 2,					//usb
                          CLIMBER_EXTEND_PORT = 1,	    			//Digital
                          COMPRESSOR_CONTROL_OVERRIDE = 2,		//Digital
                          INTAKE_IN_PORT = 4,					//Digital
                          INTAKE_OUT_PORT = 5,					//Digital
                          CLIMB_UP_PORT = 6,						//Digital TODO
                          CLIMB_DOWN_PORT = 8,					//Digital TODO
                          ARM_CONTROL_OVERRIDE = 9,				//Digital TODO
                          ARM_SOLENOID_CONTROL_OVERRIDE = 12,		//Digital TODO
                          SHOOTER_KNOB_PORT = 0,					//Analog TODO
                          AUTO_KNOB_PORT = 1,                     //Analog TODO
                          ARM_JOYSTICK_Y_PORT = 2;			    //Analog;		TODO			

  public static final double  ARM_KNOB_POS_0 = 0.000,
                              ARM_KNOB_POS_1 = 0.024,
                              ARM_KNOB_POS_2 = 0.047,
                              ARM_KNOB_POS_3 = 0.071,
                              ARM_KNOB_POS_4 = 0.094,
                              ARM_KNOB_POS_5 = 0.118,
                              AUTO_KNOB_POS_0 = 0.000,
                              AUTO_KNOB_POS_1 = 0.024,
                              AUTO_KNOB_POS_2 = 0.055,
                              AUTO_KNOB_POS_3 = 0.087;
}
