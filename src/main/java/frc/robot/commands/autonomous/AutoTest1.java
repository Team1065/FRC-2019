package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoTest1 extends CommandGroup {

    public AutoTest1() {
		//TEST OF CENTER S+S (R,R)

		addSequential(new DriveToDistance(-.7, 105, 15));
		addSequential(new DriveForTime(0,0,0.5));  // Deploy Panel

		addSequential(new DriveToDistance(.7, 10, 15));
		//addSequential(new DriveForTime(0,0,0.5));

		addSequential(new RotateToAngle(.65, 125, 15));
		//addSequential(new DriveForTime(0,0,0.5));

		addSequential(new DriveToDistance(-.8, 105, 15));
		//addSequential(new DriveForTime(0,0,0.5));

		addSequential(new RotateToAngle(.65, 180, 15));
		//addSequential(new DriveForTime(0,0,0.5));

		addSequential(new DriveToDistance(-.7, 45, 15));
		addSequential(new DriveForTime(0,0,0.5)); // Pickup panel

		addSequential(new DriveToDistance(.7, 50, 15));
		//addSequential(new DriveForTime(0,0,0.5));
		
		addSequential(new RotateToAngle(.65, 300, 15));
		//addSequential(new DriveForTime(0,0,0.5));

		addSequential(new DriveToDistance(-.8, 130, 15));
		//addSequential(new DriveForTime(0,0,0.5));

		addSequential(new RotateToAngle(.65, 359, 15));
		//addSequential(new DriveForTime(0,0,0.5));
		addSequential(new DriveToDistance(-.7, 25, 15));





		/*
		addSequential(new DriveToDistance(.4, 20, 15.0));
		
    	addSequential(new DriveForTime(0,0,2));
    	
    	addSequential(new RotateToAngle(.4, 45, 15));
		
		addSequential(new DriveForTime(0,0,2));
    	
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
