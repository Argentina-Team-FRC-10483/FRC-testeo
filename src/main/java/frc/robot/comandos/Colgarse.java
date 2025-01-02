package frc.robot.comandos;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsistemas.Enganche;

public class Colgarse extends Command{
    private final Joystick joystick = new Joystick(0); 

    private final Enganche enganche;

    double vel = joystick.getRawAxis(2) * 0.5;
    double dirrec = joystick.getRawAxis(3) * 0.5;
    
    public Colgarse(Enganche dt) {
        enganche = dt;
        addRequirements(enganche);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute(){
        enganche.elevar(vel,dirrec);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        enganche.elevar();
    }
}
