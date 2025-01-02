package frc.robot;

import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;

public class RobotContainer {
    private Drive subDrive = new Drive();

    private CommandJoystick joystick = new CommandJoystick(0);
    
    public RobotContainer(){
        subDrive.setDefaultCommand(new DriveCommand(subDrive,
                                                    () -> joystick.getRawAxis(0),
                                                    () -> joystick.getRawAxis(1)
                                                    ));
    }
}
