package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Lanzamiento;
import edu.wpi.first.wpilibj.Joystick;

public class LanzamientoCommand extends CommandBase {
    private final Lanzamiento lanzamiento;
    private final Joystick joystick;
    private final int botonLanzar;

    public LanzamientoCommand(Lanzamiento lanzamiento, Joystick joystick) {
        this.lanzamiento = lanzamiento;
        this.joystick = joystick;
        this.botonLanzar = 1; // Botón para lanzar
        addRequirements(lanzamiento);
    }

    @Override
    public void execute() {
        boolean activar = joystick.getRawButton(botonLanzar) && lanzamiento.hayDisco();
        lanzamiento.lanzar(activar);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        lanzamiento.lanzar(false); // Detener el lanzamiento
    }
}
