package frc.robot.comandos;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsistemas.Lanzamiento;

public class ComandoDejarLanzar extends Command {
    private final Lanzamiento lanzamiento;

    public ComandoDejarLanzar(Lanzamiento lanzamiento) {
        this.lanzamiento = lanzamiento;
        addRequirements(lanzamiento);
    }

    @Override
    public void initialize() {
    }

    @Override 
    public void execute() {
        lanzamiento.apagar();
    }

    @Override
    public boolean isFinished() {
        return true; 
    }
}
