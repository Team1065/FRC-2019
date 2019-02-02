package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

// Right Cargo


public class RightCargo extends CommandGroup {

    public RightCargo() {

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

    }
}
