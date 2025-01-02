package frc.robot.comandos;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsistemas.Lanzamiento;

public class ComandosLanzar extends Command {
    private final Lanzamiento lanzamiento;

    public ComandosLanzar(Lanzamiento lanzamiento) {
        this.lanzamiento = lanzamiento;
        addRequirements(lanzamiento);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        lanzamiento.lanzar();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
