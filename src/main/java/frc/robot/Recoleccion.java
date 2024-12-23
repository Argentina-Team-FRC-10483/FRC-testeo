package frc.robot;

public class Recoleccion {
    public static void recoleccionPeriodico(Spark motorAbajoRecoleccion, Spark motorArribaRecoleccion){
        motorAbajoRecoleccion.set(1.0);
        motorArribaRecoleccion.set(-1.0);
    }
}
