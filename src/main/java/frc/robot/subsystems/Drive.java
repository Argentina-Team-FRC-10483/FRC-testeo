package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {

    private Spark motorAdelanteIzquierda = new Spark(2);
    private Spark motorAdelanteDerecha = new Spark(3);
    private Spark motorAtrasIzquierda = new Spark(4);
    private Spark motorAtrasDerecha = new Spark(5);

    public void drive(double xAxis, double yAxis) {
        double velocidad = yAxis * 0.6; //el negativo significa que arriba es negativo y abajo es positivo
        double giro = xAxis * 0.3;

        double d = velocidad + giro;
        double d2 = velocidad - giro;

        motorAdelanteIzquierda.set(d);
        motorAtrasIzquierda.set(d2);
        motorAdelanteDerecha.set(-d2); // Invertido por montaje físico
        motorAtrasDerecha.set(-d);  // Invertido por montaje físico
    }

    public void stop(){
        motorAdelanteIzquierda.set(0);
        motorAtrasIzquierda.set(0);
        motorAdelanteDerecha.set(0);
        motorAtrasDerecha.set(0);
    }
}