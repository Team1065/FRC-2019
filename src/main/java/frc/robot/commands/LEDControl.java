/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class LEDControl extends Command {
  public LEDControl() {
    requires(Robot.m_lighting);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    boolean cargoLedState = false;

    if(Robot.m_cargoHandler.isCargoDetected()){
        double timeDecimal = Timer.getFPGATimestamp() % 1.0;
        if(Robot.m_elevator.getBottomLimit()){ // TODO: change to shooter at speed
            cargoLedState = true;
        }
        else if(timeDecimal < 0.25 || (timeDecimal > 0.5 && timeDecimal < 0.75) ){
            cargoLedState = true;
        }
    }

    Robot.m_lighting.setCargoLED(cargoLedState);
    Robot.m_lighting.setLED2(cargoLedState);
    Robot.m_lighting.setLED2(cargoLedState);
    Robot.m_lighting.setLED3(cargoLedState);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}