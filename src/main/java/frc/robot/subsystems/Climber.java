/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.ManualClimberControl;

public class Climber extends Subsystem {
  private Talon backMotors;
  private Solenoid frontActuator;
  private DigitalInput backBottomLimit, backTopLimit;

  public Climber() {
    backMotors = new Talon(RobotMap.CLIMBER_MOTORS_PORT);
    frontActuator = new Solenoid(RobotMap.CLIMBER_SOLENOID_PORT);
    backBottomLimit = new DigitalInput(RobotMap.CLIMBER_BOTTOM_LIMIT_PORT);
    backTopLimit = new DigitalInput(RobotMap.CLIMBER_TOP_LIMIT_PORT);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ManualClimberControl());
  }

  public void setBackMotors(double speed) {
    backMotors.set(speed);
    //assume normally open switches
    if(speed < 0 && !backBottomLimit.get() || 
       speed > 0 && !backTopLimit.get()) {
        backMotors.set(0);
    }
    else{
      backMotors.set(speed);
    }
  }

  public void setFrontActuator(boolean extend) {
    frontActuator.set(extend);
  }

  public void updateStatus(){
    SmartDashboard.putBoolean("Climber Bottom Limit", !backBottomLimit.get());
    SmartDashboard.putBoolean("Climber Top Limit", !backTopLimit.get());
  }
}
