package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Recoleccion extends SubsystemBase {
    private final Spark motorAbajo = new Spark(8);
    private final Spark motorArriba = new Spark(9);

    public void recolectar() {
        motorAbajo.set(1.0);
        motorArriba.set(-1.0);
    }

    public void detener() {
        motorAbajo.set(0.0);
        motorArriba.set(0.0);
    }
}
