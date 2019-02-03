/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.ManualElevatorControl;

public class Elevator extends Subsystem {
  private TalonSRX talon;
  private DigitalInput bottomLimit, topLimit;

  public Elevator (){
    bottomLimit = new DigitalInput(RobotMap.ELEVATOR_BOTTOM_LIMIT_PORT);
    topLimit = new DigitalInput(RobotMap.ELEVATOR_TOP_LIMIT_PORT);

    talon = new TalonSRX(RobotMap.ELEVATOR_TALON_PORT);

    talon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		talon.setSensorPhase(true);
		talon.setInverted(true);
		talon.configNominalOutputForward(0.0, 0);
		talon.configNominalOutputReverse(-0.0, 0);
		talon.configPeakOutputForward(1, 0);
		talon.configPeakOutputReverse(-1, 0);
		talon.configAllowableClosedloopError(0, RobotMap.ELEVATOR_ERROR, 0);
		talon.config_kF(0, RobotMap.ELEVATOR_F, 0);
		talon.config_kP(0, RobotMap.ELEVATOR_P, 0);
		talon.config_kI(0, RobotMap.ELEVATOR_I, 0);
		talon.config_kD(0, RobotMap.ELEVATOR_D, 0);
		
		//There is an option to get the absolute value from the CTR sensor but we will just zero it out for now
		talon.setSelectedSensorPosition(0, 0, 0);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ManualElevatorControl());
  }

  public void setPosition(double position) {
    //assume normally open switches
    if(position < talon.getSelectedSensorPosition(0) && !bottomLimit.get()) {
      talon.set(ControlMode.PercentOutput, 0);
      talon.setSelectedSensorPosition(0, 0, 0);
    }
    else if (position > talon.getSelectedSensorPosition(0) && !topLimit.get()) {
      talon.set(ControlMode.PercentOutput, 0);
    }
    else{
      talon.set(ControlMode.Position,position);
    }
  }

  public void setVoltage(double speed) {
    //assume normally open switches
    if((speed < 0 && !bottomLimit.get()) || (speed > 0 && !topLimit.get())){
      talon.set(ControlMode.PercentOutput, 0);
    }
    else{
      talon.set(ControlMode.PercentOutput, speed);
    }
  }
  
  public boolean isOnTarget(){
    return talon.getClosedLoopError(0) < RobotMap.ELEVATOR_ERROR;
  }
  
  public void updateStatus(){
    SmartDashboard.putNumber("Elevator Talon Motor Speed", talon.getMotorOutputPercent());
    SmartDashboard.putNumber("Elevator Setpoint", talon.getClosedLoopTarget(0));
    SmartDashboard.putNumber("Elevator Error", talon.getClosedLoopError(0));
    SmartDashboard.putNumber("Elevator Position", talon.getSelectedSensorPosition(0));
    SmartDashboard.putBoolean("Elevator on Target", isOnTarget());
    SmartDashboard.putBoolean("Elevator Bottom Limit", !bottomLimit.get());
    SmartDashboard.putBoolean("Elevator Top Limit", !topLimit.get());
  }

}
