package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Enganche extends SubsystemBase {
    private final Spark motorLeft = new Spark(6);
    private final Spark motorRight = new Spark(7);

    public void mover(double velocidad, double direccion) {
        double top = velocidad + direccion;
        double bottom = velocidad - direccion;

        motorLeft.set(top);
        motorRight.set(bottom);
    }
}
