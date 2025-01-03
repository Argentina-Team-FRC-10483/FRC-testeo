package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Enganche;
import edu.wpi.first.wpilibj.Joystick;

public class EngancheCommand extends CommandBase {
    private final Enganche enganche;
    private final Joystick joystick;

    public EngancheCommand(Enganche enganche, Joystick joystick) {
        this.enganche = enganche;
        this.joystick = joystick;
        addRequirements(enganche);
    }

    @Override
    public void execute() {
        double velocidad = joystick.getRawAxis(2) * 0.5; // Eje para velocidad
        double direccion = joystick.getRawAxis(3) * 0.5; // Eje para dirección
        enganche.mover(velocidad, direccion);
    }
}
