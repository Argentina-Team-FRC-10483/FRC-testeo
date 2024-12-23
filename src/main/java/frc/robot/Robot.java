package frc.robot;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.Spark;


public class Robot extends TimedRobot {

  // Motores lanzamiento
  private final Spark motorArriba = new Spark(0); // Puerto PWM 0
  private final Spark motorAbajo = new Spark(1); // Puerto PWM 1

  // Joystick
  private final Joystick joystick = new Joystick(0); // Puerto USB 0

  // boton para activar los motores lanzamiento
  private final int botonActivarTiro = 1; // Botón 1 del joystick

  //boton de disparo forzado
  private final int botonDisparoForzado = 2; // botón 2 del joystick

  // temporizador lanzamiento disparo forzado
  private final Timer timer = new Timer();

  // indicar si los motores lanzamiento están activos
  private boolean estanActivos = false;

  // sensor para detectar si hay un disco zona de lanzamiento
  private final DigitalInput sensorDisco = new DigitalInput(0); // Puerto DIO 0

  //Indica si se encuentra o no un disco zona de lanzamiento
  private boolean hayDisco = false; //no importa que inicie en falso porque este valor se actualiza todo el tiempo

  @Override
  public void robotPeriodic() {
    //esto se esta actualizando todo el tiempo
    hayDisco = sensorDisco.get(); // true si el sensor detecta el disco, false si no
  }

  @Override
  public void teleopPeriodic() {
    // verifica si el botón está presionado y los motores no están corriendo
    if (joystick.getRawButtonPressed(botonActivarTiro) && !estanActivos && hayDisco) {
      estanActivos = true;

      // Encender motores: uno hacia adelante, otro hacia atrás
      motorArriba.set(1.0); // Velocidad máxima hacia adelante
      motorAbajo.set(-1.0); // Velocidad máxima hacia atrás
    }

    if (joystick.getRawButtonPressed(botonDisparoForzado) && !estanActivos) {
      estanActivos = true;
      timer.reset();
      timer.start();

      // Encender motores: uno hacia adelante, otro hacia atrás
      motorArriba.set(1.0); // Velocidad máxima hacia adelante
      motorAbajo.set(-1.0); // Velocidad máxima hacia atrás
    }

    //apagar si no hay disco
    if (estanActivos && !hayDisco) {
      motorArriba.set(0.0);
      motorAbajo.set(0.0);
      estanActivos = false;
    }

    // Detener motores después de 1 segundos si se activo el disparo forzado
    if (estanActivos && timer.get() >= 1.0) {
      motorArriba.set(0.0);
      motorAbajo.set(0.0);
      estanActivos = false;
      timer.stop();
    }

  }
}