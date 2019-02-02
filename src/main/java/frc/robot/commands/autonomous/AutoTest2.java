package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoTest2 extends CommandGroup {

    public AutoTest2() {
		//TEST OF CENTER S+S (R,R)
		addSequential(new DriveToDistance(.9, 120, 15));

		addSequential(new RotateToAngle(.8, 40, 15));

		addSequential(new DriveToDistance(.9, 110, 15));

		addSequential(new RotateToAngle(.8, -40, 15));

		addSequential(new DriveToDistance(-.5, 15, 15));
		addSequential(new DriveForTime(0, 0, 1));

		addSequential(new DriveToDistance(.6, 30, 15));

		addSequential(new RotateToAngle(.8, 0, 15));

		addSequential(new DriveToDistance(-.9, 70, 15));

		addSequential(new RotateToAngle(.8, -35, 15));

		addSequential(new DriveToDistance(-.8, 30, 15));

		addSequential(new RotateToAngle(.8, 0, 15));

		addSequential(new DriveToDistance(-.8, 60, 15));
		addSequential(new DriveForTime(0, 0, 1));

		addSequential(new DriveToDistance(.7, 20, 15));

		addSequential(new RotateToAngle(.8, -10, 15));

		addSequential(new DriveToDistance(1, 150, 15));

		addSequential(new RotateToAngle(.8, -120, 15));

		addSequential(new DriveToDistance(-.7, 25, 15));

		addSequential(new RotateToAngle(.8, -35, 15));

		addSequential(new DriveToDistance(-.6, 10, 15));
		addSequential(new DriveForTime(0, 0, 1));



		/*
    	addSequential(new DriveToDistance(-0.8, 15, 15.0));
    	//addSequential(new DriveForTime(0,0,0.5));
    	
    	addSequential(new RotateToAngle(.4, 47, 15.0));
    	//addSequential(new DriveForTime(0,0,0.5));
    	
    	addSequential(new DriveToDistance(-0.8, 110, 15.0));
    	//addSequential(new DriveForTime(0,0,0.5));
    	
    	addSequential(new RotateToAngle(.4, 0, 15.0));
    	//addSequential(new DriveForTime(0,0,0.5));
    	
    	addSequential(new DriveToDistance(-0.8, 50, 15.0));
    	//addSequential(new DriveForTime(0,0,0.5));
    	
    	addSequential(new RotateToAngle(.4, 40, 15.0));
    	//addSequential(new DriveForTime(0,0,0.5));
    	
    	addSequential(new DriveToDistance(0.8, 7, 15.0));
    	//addSequential(new DriveForTime(0,0,2.0));
    	//DUMP
    	addSequential(new DriveToDistance(-0.8, 20, 15.0));
    	//addSequential(new DriveForTime(0,0,0.5));
    	
    	addSequential(new RotateToAngle(.4, 73, 15.0));
    	//addSequential(new DriveForTime(0,0,0.5));
    	
    	addSequential(new DriveToDistance(0.8, 10, 15.0));
    	//addSequential(new DriveForTime(0,0,2.0));
    	//PICKUP
    	addSequential(new RotateToAngle(.4, -10, 15.0));
    	//addSequential(new DriveForTime(0,0,0.5));
    	
    	addSequential(new DriveToDistance(-0.8, 57, 15.0));
    	//addSequential(new DriveForTime(0,0,2.0));
		//DUMP
		*/
    }
}
