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
  //Shooter RPM values
  public static final double ELEVATOR_POS_0 = 0.0,//Cargo
                             ELEVATOR_POS_1 = 0.0,//Rocket Low
                             ELEVATOR_POS_2 = 10000.0,//Rocket Mid
                             ELEVATOR_POS_3 = 20000.0,//Rocket High
                             ELEVATOR_POS_4 = 20000.0,//Rocket High
                             ELEVATOR_POS_5 = 20000.0;//Rocket High

  //PID Constants
  public static final double MECANUM_STRAIGHT_DRIVE_P = 0.023,
                             ELEVATOR_F = 0,
                             ELEVATOR_P = 0.005,
                             ELEVATOR_I = 0,
                             ELEVATOR_D = 0;

  //Int Constants
  public static final int ELEVATOR_ERROR = 2000;//4098 is 1 full rotation

  //Double Constants
  public static final double JOYSTICK_DEADBAND = 0.05,
                              DRIVE_STRAIGHT_BAND_PERCENTAGE = 0.25,
                              DRIVE_WHEEL_DIAMETER = 6,
                              DRIVE_ENCODERS_COUNTS_PER_REV = 20,
                              ELEVATOR_JOYSTICK_MIDDLE = 0.063,
							                ELEVATOR_JOYSTICK_DEADBAND = 0.01;

  //PWM Ports
  public static final int LEFT_FRONT_DRIVE_MOTOR_PORT = 0,
                          RIGHT_FRONT_DRIVE_MOTOR_PORT = 1,
                          LEFT_BACK_DRIVE_MOTOR_PORT = 2,
                          RIGHT_BACK_DRIVE_MOTOR_PORT = 3,
                          CLIMBER_MOTORS_PORT = 4;

 //CAN Ports
  public static final int INTAKE_VICTOR_PORT = 1,
                          INDEXER_MID_VICTOR_PORT = 2,
                          INDEXER_TOP_VICTOR_PORT = 3,
                          SHOOTER_VICTOR_PORT = 4,
                          ELEVATOR_TALON_PORT = 1;

  //PCM Ports
  public static final int DROPDOWN_SOLENOID_PORT = 1,
                          CLIMBER_SOLENOID_PORT = 2;

  //Digital Ports
  public static final int DRIVE_ENCODER_PORT_A = 0,
                          DRIVE_ENCODER_PORT_B = 1,
                          CARGO_SWITCH_PORT = 2,
                          ELEVATOR_BOTTOM_LIMIT_PORT = 3,
                          ELEVATOR_TOP_LIMIT_PORT = 4,
                          CLIMBER_BOTTOM_LIMIT_PORT = 5,
                          CLIMBER_TOP_LIMIT_PORT = 6;

  //OI
  public static final int LEFT_JOYSTICK_PORT = 0,					//usb
                          RIGHT_JOYSTICK_PORT = 1,				//usb
                          ENHANCED_DS_PORT = 2,					//usb
                          CLIMBER_EXTEND_PORT = 1,	    			//Digital
                          COMPRESSOR_CONTROL_OVERRIDE = 2,		//Digital
                          INTAKE_IN_PORT = 4,					//Digital
                          INTAKE_OUT_PORT = 5,					//Digital
                          ARM_UP_PORT = 6,						//Digital TODO
                          ARM_DOWN_PORT = 8,					//Digital TODO
                          ELEVATOR_CONTROL_OVERRIDE = 9,				//Digital TODO
                          ELEVATOR_SOLENOID_CONTROL_OVERRIDE = 12,		//Digital TODO
                          ELEVATOR_KNOB_PORT = 0,					//Analog TODO
                          AUTO_KNOB_PORT = 1,                     //Analog TODO
                          ELEVATOR_JOYSTICK_Y_PORT = 2;			    //Analog;		TODO			

  public static final double  ELEVATOR_KNOB_POS_0 = 0.000,
                              ELEVATOR_KNOB_POS_1 = 0.024,
                              ELEVATOR_KNOB_POS_2 = 0.047,
                              ELEVATOR_KNOB_POS_3 = 0.071,
                              ELEVATOR_KNOB_POS_4 = 0.094,
                              ELEVATOR_KNOB_POS_5 = 0.118,
                              AUTO_KNOB_POS_0 = 0.000,
                              AUTO_KNOB_POS_1 = 0.024,
                              AUTO_KNOB_POS_2 = 0.055,
                              AUTO_KNOB_POS_3 = 0.087;
}
