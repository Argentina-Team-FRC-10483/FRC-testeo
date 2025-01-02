package frc.robot.subsistemas;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lanzamiento extends SubsystemBase {
  // verifica si el botón está presionado y los motores no están corriendo
  Spark motorArribaLanzamiento;
  Spark motorAbajoLanzamiento;
  boolean estanActivos;

  public Lanzamiento(int puertoMotorArriba, int puertoMotorAbajo) {
    motorArribaLanzamiento = new Spark(puertoMotorArriba);
    motorAbajoLanzamiento = new Spark(puertoMotorAbajo);
    estanActivos = false;
  }

  public void lanzar() {
    if (!estanActivos) {
      // Encender motores: uno hacia adelante, otro hacia atrás
      motorArribaLanzamiento.set(1.0); // Velocidad máxima hacia adelante
      motorAbajoLanzamiento.set(-1.0); // Velocidad máxima hacia atrás
      estanActivos = true;
    }
  }

  /*
   * if (joystick.getRawButtonPressed(botonDisparoForzado)) {
   * estanActivos = true;
   * timer.reset();
   * timer.start();
   * System.out.println("Dispare");
   * // Encender motores: uno hacia adelante, otro hacia atrás
   * motorArribaLanzamiento.set(1.0); // Velocidad máxima hacia adelante
   * motorAbajoLanzamiento.set(-1.0); // Velocidad máxima hacia atrás
   * }
   */

  // apagar si no hay disco
  public void apagar() {
    motorArribaLanzamiento.set(0.0);
    motorAbajoLanzamiento.set(0.0);
    estanActivos = false;
  }

  /*
   * // Detener motores después de 1 segundos si se activo el disparo forzado
   * if (estanActivos && timer.get() >= 1.0) {
   * motorArribaLanzamiento.set(0.0);
   * motorAbajoLanzamiento.set(0.0);
   * estanActivos = false;
   * timer.stop();
   * }
   */

  public boolean isActivo() {
    return estanActivos;
  }

}
