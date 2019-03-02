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
  private Solenoid frontActuator, backActuator;

  public Climber() {
    frontActuator = new Solenoid(RobotMap.FROMT_CLIMBER_SOLENOID_PORT);
    backActuator = new Solenoid(RobotMap.BACK_CLIMBER_SOLENOID_PORT);
  }
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ManualClimberControl());
  }

  public void setFrontActuator(boolean extend) {
    frontActuator.set(extend);
  }

  public void setBackActuator(boolean extend) {
    backActuator.set(extend);
  }

  public void updateStatus(){
  }
}

