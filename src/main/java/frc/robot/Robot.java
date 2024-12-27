package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Robot extends TimedRobot {

  // Joystick
  private final Joystick joystick = new Joystick(0); // Puerto USB 0

  // Botón para activar los motores lanzamiento
  private final int botonActivarTiro = 1; // Botón 1 del joystick

  // Botón de disparo forzado
  private final int botonDisparoForzado = 2; // Botón 2 del joystick

  // Temporizador lanzamiento disparo forzado
  private final Timer timer = new Timer();

  // Indicar si los motores lanzamiento están activos
  private boolean estanActivos = false;

  // Sensor para detectar si hay un disco en la zona de lanzamiento
  private final DigitalInput sensorDisco = new DigitalInput(0); // Puerto DIO 0

  // Indica si se encuentra o no un disco en la zona de lanzamiento
  private boolean hayDisco = false; // No importa que inicie en falso porque este valor se actualiza todo el tiempo

  // Motores
  
  // Lanzamiento
  private final Spark motorArribaLanzamiento = new Spark(0); // Puerto PWM 0
  private final Spark motorAbajoLanzamiento = new Spark(1); // Puerto PWM 1

  // Movimiento
  private Spark motorAdelanteIzquierdaMovimiento = new Spark(2); // Puerto PWM 2
  private Spark motorAdelanteDerechaMovimiento = new Spark(3); // Puerto PWM 3
  private Spark motorAtrasIzquierdaMovimiento = new Spark(4); // Puerto PWM 4
  private Spark motorAtrasDerechaMovimiento = new Spark(5); // Puerto PWM 5

  // Recolección
  private Spark motorArribaRecoleccion = new Spark(6); // Puerto PWM 6
  private Spark motorAbajoRecoleccion = new Spark(7); // Puerto PWM 7


  // Enganche
  private Spark motorLeftEnganche = new Spark(8); // Puerto PWM 8
  private Spark motorRightEnganche = new Spark(9); // Puerto PWM 9

  @Override
  public void robotPeriodic() {
    // Esto se está actualizando todo el tiempo
    hayDisco = sensorDisco.get(); // True si el sensor detecta el disco, false si no
  }

  @Override
  public void teleopPeriodic() {
    Lanzamiento.lanzamientoPeriodico(motorArribaLanzamiento, motorAbajoLanzamiento, joystick, botonActivarTiro, botonDisparoForzado, timer, estanActivos, sensorDisco, hayDisco);
    Movimiento.movimientoPeriodico(joystick, motorAdelanteIzquierdaMovimiento, motorAdelanteDerechaMovimiento, motorAtrasIzquierdaMovimiento, motorAtrasDerechaMovimiento);
    Enganche.enganchePeriodico(joystick, motorLeftEnganche, motorRightEnganche);
    Recoleccion.recoleccionPeriodico(motorAbajoRecoleccion, motorArribaRecoleccion);
  }
}
