package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.comandos.ComandoDejarLanzar;
import frc.robot.comandos.ComandosLanzar;
import frc.robot.subsistemas.Lanzamiento;

public class RobotContainer {
    private final Joystick joystick = new Joystick(0);
    private final Lanzamiento lanzamiento = new Lanzamiento(0, 1); // puertos locos de los motores
    //private final JoystickButton botonLanzar = new JoystickButton(joystick, 3);
    //private final JoystickButton botonApagar = new JoystickButton(joystick, 2);

    public RobotContainer() {
        configureButtonBindings();
    }

    private void configureButtonBindings() {
        new Trigger(() -> joystick.getRawButton(2)).onTrue(new ComandosLanzar(lanzamiento));
        //sbotonApagar.onTrue(new ComandoDejarLanzar(lanzamiento));
    }
}