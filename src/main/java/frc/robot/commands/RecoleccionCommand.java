package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Recoleccion;

public class RecoleccionCommand extends CommandBase {
    private final Recoleccion recoleccion;

    public RecoleccionCommand(Recoleccion recoleccion) {
        this.recoleccion = recoleccion;
        addRequirements(recoleccion);
    }

    @Override
    public void execute() {
        recoleccion.recolectar();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        recoleccion.detener();
    }
}
