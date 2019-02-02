package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

// Left Rocket

public class LeftRocket extends CommandGroup {

    public LeftRocket() {
    	addSequential(new DriveToDistance(.9, 120, 15));

		addSequential(new RotateToAngle(.8, -40, 15));

		addSequential(new DriveToDistance(.9, 110, 15));

		addSequential(new RotateToAngle(.8, 40, 15));

		addSequential(new DriveToDistance(-.5, 15, 15)); 
		// Deploy Panel
		addSequential(new DriveForTime(0, 0, 1));

		addSequential(new DriveToDistance(.6, 30, 15));

		addSequential(new RotateToAngle(.8, 0, 15));

		addSequential(new DriveToDistance(-.9, 70, 15));

		addSequential(new RotateToAngle(.8, 35, 15));

		addSequential(new DriveToDistance(-.8, 30, 15));

		addSequential(new RotateToAngle(.8, 0, 15));

		addSequential(new DriveToDistance(-.8, 60, 15)); 
		// Get New Panel
		addSequential(new DriveForTime(0, 0, 1));

		addSequential(new DriveToDistance(.7, 20, 15));

		addSequential(new RotateToAngle(.8, 10, 15));

		addSequential(new DriveToDistance(1, 150, 15));

		addSequential(new RotateToAngle(.8, 120, 15));

		addSequential(new DriveToDistance(-.7, 25, 15));

		addSequential(new RotateToAngle(.8, 35, 15));

		addSequential(new DriveToDistance(-.6, 10, 15));
		// Deploy Panel
    }
}
