package frc.robot.subsistemas;

import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Recoleccion {
    public static void recoleccionPeriodico(Spark motorAbajoRecoleccion, Spark motorArribaRecoleccion){
        motorAbajoRecoleccion.set(1.0);
        motorArribaRecoleccion.set(-1.0);
    }
}

//Girara desde el inicio