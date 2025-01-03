package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;

public class RobotContainer {
    // Subsistemas
    private final Movimiento movimiento = new Movimiento();
    private final Lanzamiento lanzamiento = new Lanzamiento();
    private final Recoleccion recoleccion = new Recoleccion();
    private final Enganche enganche = new Enganche();

    // Joystick
    private final CommandJoystick joystick = new CommandJoystick(0);

    public RobotContainer() {
        // Comandos por defecto
        subDrive.setDefaultCommand(new DriveCommand(subDrive,
         () -> joystick.getRawAxis(0),
         () -> joystick.getRawAxis(1)
          ));
        recoleccion.setDefaultCommand(new RecoleccionCommand(recoleccion));
        enganche.setDefaultCommand();
        lanzamiento.setDefaultCommand(new LanzamientoCommand(lanzamiento,

            ));
    }
}
