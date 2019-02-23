/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ManualCameraControl;
import frc.robot.RobotMap;

public class VisionSystem extends Subsystem {
    public enum State{FRONT_CAMERA_VIEW, RIGHT_CAMERA_VIEW, LEFT_CAMERA_VIEW, BACK_CAMERA_VIEW};
    Servo mount;
	UsbCamera camera0;
	//UsbCamera camera1;
	//CvSink cvSink0, cvSink1;
	////CvSource outputStream;
	//Mat image;
	State currSession;
  public VisionSystem() {
    mount = new Servo(RobotMap.CAMERA_SERVO_PORT);
    setMount(0);
    
    camera0 = CameraServer.getInstance().startAutomaticCapture(0);
    camera0.setFPS(15);
    camera0.setResolution(320, 240);
    camera0.setExposureManual(40);
    camera0.setExposureHoldCurrent();
      
  }


  public void setMount(double val){
        if (val < 0.08){
            val = 0.08;
        }
        else if (val > 0.44){
            val = 0.44;
        }
        mount.set(val);
    }

    public double getMount(){
        return mount.get();
    }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ManualCameraControl());
  }

}
