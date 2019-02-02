/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  Joystick leftJoystick, rightJoystick, enhancedDS;
	
	public OI() {
		leftJoystick = new Joystick(RobotMap.LEFT_JOYSTICK_PORT);
		rightJoystick = new Joystick(RobotMap.RIGHT_JOYSTICK_PORT);
	    enhancedDS = new Joystick(RobotMap.ENHANCED_DS_PORT);
	}
	
	public double getLeftJoystickY () {
		if(Math.abs(leftJoystick.getY()) < RobotMap.JOYSTICK_DEADBAND){
			return 0;
		}
	    else {
	    	return -leftJoystick.getY();
	    }
	}
	
	public double getRightJoystickY () {
		if(Math.abs(rightJoystick.getY()) < RobotMap.JOYSTICK_DEADBAND){
			return 0;
		}
	    else {
	    	return -rightJoystick.getY();
	    }
	}
	
	public double getRightJoystickX () {
		if(Math.abs(rightJoystick.getX()) < RobotMap.JOYSTICK_DEADBAND){
			return 0;
		}
	    else {
	    	return rightJoystick.getX();
	    }
	}
	public boolean getRightJoystickTrigger(){
    	return rightJoystick.getTrigger();
    }
    
    public boolean getRightJoystickTop(){
    	return rightJoystick.getTop();
    }

    public boolean getRightJoystickTopRight(){
        return rightJoystick.getRawButton(5);
    }

    public boolean getRightJoystickTopLeft(){
        return rightJoystick.getRawButton(4);
    }
    
    public boolean getLeftJoystickTop(){
    	return leftJoystick.getTop();
    }
    
    public boolean getLeftJoystickTrigger(){
    	return leftJoystick.getTrigger();
    }
    
    public boolean getCompressorOverride(){
    	return enhancedDS.getRawButton(RobotMap.COMPRESSOR_CONTROL_OVERRIDE);
    }
    
    public boolean getClimberUpSwitch(){
    	return enhancedDS.getRawButton(RobotMap.CLIMB_UP_PORT);
    }
    
    public boolean getClimberDownSwitch(){
    	return enhancedDS.getRawButton(RobotMap.CLIMB_DOWN_PORT);
    }
    
    public double getArmStickY(){
    	return enhancedDS.getRawAxis(RobotMap.ARM_JOYSTICK_Y_PORT);
    }
    
    public boolean getArmOverride(){
    	return enhancedDS.getRawButton(RobotMap.ARM_CONTROL_OVERRIDE);
    }
    
    public boolean getArmExtendedOverride(){
    	return enhancedDS.getRawButton(RobotMap.ARM_SOLENOID_CONTROL_OVERRIDE);
    }
    
    public boolean getIntakeIn(){
    	return enhancedDS.getRawButton(RobotMap.INTAKE_IN_PORT);
    }
    
    public boolean getIntakeOut(){
    	return enhancedDS.getRawButton(RobotMap.INTAKE_OUT_PORT);
    }
    
    public int getAutoKnobPosition(){
    	int position;
      double knobValue = enhancedDS.getRawAxis(RobotMap.AUTO_KNOB_PORT);
      double threshold = 0.010;
      
      //Introduce the use of a switch to double the number of auto modes we are able to select
      
      //If Station Knob is at 1
      if(knobValue < RobotMap.AUTO_KNOB_POS_0 + threshold){
              position = 0;
          }
          //If Station Knob is at 2
          else if(knobValue >= RobotMap.AUTO_KNOB_POS_1 - threshold && knobValue < RobotMap.AUTO_KNOB_POS_1 + threshold){
              position = 1;
          }
          //If Station Knob is at 3
          else if(knobValue >= RobotMap.AUTO_KNOB_POS_2 - threshold && knobValue < RobotMap.AUTO_KNOB_POS_2 + threshold){
              position = 2;
          }
          //If Station Knob is at 4
          else if(knobValue >= RobotMap.AUTO_KNOB_POS_3 - threshold && knobValue < RobotMap.AUTO_KNOB_POS_3 + threshold){
              position = 3;
          }
          else
          {
            position = 0;
          }
      
      return position;
	}
}
