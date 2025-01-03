package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lanzamiento extends SubsystemBase {
    private final Spark motorArriba = new Spark(0);
    private final Spark motorAbajo = new Spark(1);
    private final DigitalInput sensorDisco = new DigitalInput(0);

    public void lanzar(boolean activar) {
        if (activar) {
            motorArriba.set(1.0);
            motorAbajo.set(-1.0);
        } else {
            motorArriba.set(0.0);
            motorAbajo.set(0.0);
        }
    }

    public boolean hayDisco() {
        return sensorDisco.get();
    }
}
