/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.ManualCargoHandlerControl;

public class CargoHandler extends Subsystem {
  public enum IntakeState{OFF, IN, OUT};
  public enum ShooterState{OFF, FRONT, RIGHT, LEFT};

  private VictorSPX intake, indexerMid, indexerTop, shooter;
  private DigitalInput cargoDetection;
  private IntakeState intakeState;
  private ShooterState shooterState;

  public CargoHandler(){
    intake = new VictorSPX(RobotMap.INTAKE_VICTOR_PORT);
    indexerMid = new VictorSPX(RobotMap.INDEXER_MID_VICTOR_PORT);
    indexerTop = new VictorSPX(RobotMap.INDEXER_TOP_VICTOR_PORT);
    shooter = new VictorSPX(RobotMap.SHOOTER_VICTOR_PORT);

    intake.setInverted(true);
    indexerMid.setInverted(true);
    indexerTop.setInverted(false);
    shooter.setInverted(true);

    cargoDetection = new DigitalInput(RobotMap.CARGO_SWITCH_PORT);
    
    intakeState = IntakeState.OFF;
    shooterState = ShooterState.OFF;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ManualCargoHandlerControl());
  }

  public void update(){
    //INTAKE AND MIDDLE INDEXER
    if(intakeState == IntakeState.OFF){
      if(shooterState != ShooterState.OFF){
        setIntake(0.7);
        setIndexerMid(0.7);
      }
      else{
        setIntake(0);
        setIndexerMid(0);
      }
    }
    else if(intakeState == IntakeState.IN){
      if(shooterState != ShooterState.OFF){
        setIntake(1);
        setIndexerMid(1);
      }
      else if(isCargoDetected()){
        setIntake(-0.8);
        setIndexerMid(0);
      }
      else{
        setIntake(1);
        setIndexerMid(0.7);
      }
    }
    else if(intakeState == IntakeState.OUT){
      if(shooterState != ShooterState.OFF){
        setIntake(1);
        setIndexerMid(1);
      }
      else{
        setIntake(-1);
        setIndexerMid(-1);
      }
    }

    //Really dirty code
    double[][] shooterConfigs = {
       new double[] {0.5,0.5}, //shooter, indexerTop
       new double[] {0.6,0.0}, //shooter, indexerTop
       new double[] {0.7,0.7}, //shooter, indexerTop
       new double[] {1,0.7} //shooter, indexerTop
    };

    int shooterConfigSelector = Robot.m_oi.getAutoKnobPosition();

    //TOP INDEXER AND SHOOTER
    if(shooterState == ShooterState.OFF){
      setShooter(0);
      if(intakeState == IntakeState.OUT){
        setIndexerTop(-1);
      }
      else{
        setIndexerTop(0);
      }
    }
    else if(shooterState == ShooterState.FRONT){
      setShooter(0);
      setIndexerTop(0);
      setIntake(1);
      setIndexerMid(-1);
    }
    else if(shooterState == ShooterState.LEFT){
      setShooter(-1);
      setIndexerTop(0.7);
    }
    else if(shooterState == ShooterState.RIGHT){
      setShooter(shooterConfigs[shooterConfigSelector][0]);
      setIndexerTop(shooterConfigs[shooterConfigSelector][1]);
    }
  }

  public boolean isCargoDetected(){
   return !cargoDetection.get();
  }

  public void setIntake(double speed){
    intake.set(ControlMode.PercentOutput, speed);
  }

  public void setIndexerMid(double speed){
    indexerMid.set(ControlMode.PercentOutput, speed);
  }

  public void setIndexerTop(double speed){
    indexerTop.set(ControlMode.PercentOutput, speed);
  }

  public void setShooter(double speed){
    shooter.set(ControlMode.PercentOutput, speed);
  }

  public void setIntakeState (IntakeState state){
    intakeState = state;
  }

  public void setShooterState (ShooterState state){
    shooterState = state;
  }

  public void updateStatus(){
    SmartDashboard.putBoolean("[CH] Cargo Detected", isCargoDetected());
    SmartDashboard.putString("[DT] Intake State", intakeState.toString());
    SmartDashboard.putString("[DT] Shooter State", shooterState.toString());
  }
}
