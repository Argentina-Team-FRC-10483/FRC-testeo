package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Lanzamiento {

    public static void lanzamientoPeriodico(Spark motorArribaLanzamiento, Spark motorAbajoLanzamiento, Joystick joystick, int botonActivarTiro, int botonDisparoForzado, Timer timer, boolean estanActivos, DigitalInput sensorDisco, boolean hayDisco) {

        // verifica si el botón está presionado y los motores no están corriendo
    if (joystick.getRawButtonPressed(botonActivarTiro) && !estanActivos && hayDisco) {
        estanActivos = true;
  
        // Encender motores: uno hacia adelante, otro hacia atrás
        motorArribaLanzamiento.set(1.0); // Velocidad máxima hacia adelante
        motorAbajoLanzamiento.set(-1.0); // Velocidad máxima hacia atrás
      }
  
      if (joystick.getRawButtonPressed(botonDisparoForzado)) {
        estanActivos = true;
        timer.reset();
        timer.start();
         System.out.println("Dispare");
        // Encender motores: uno hacia adelante, otro hacia atrás
        motorArribaLanzamiento.set(1.0); // Velocidad máxima hacia adelante
        motorAbajoLanzamiento.set(-1.0); // Velocidad máxima hacia atrás
      }
  
      //apagar si no hay disco
      if (estanActivos && !hayDisco) {
        motorArribaLanzamiento.set(0.0);
        motorAbajoLanzamiento.set(0.0);
        estanActivos = false;
      }
  
      // Detener motores después de 1 segundos si se activo el disparo forzado
      if (estanActivos && timer.get() >= 1.0) {
        motorArribaLanzamiento.set(0.0);
        motorAbajoLanzamiento.set(0.0);
        estanActivos = false;
        timer.stop();
      }
  
    }
}
