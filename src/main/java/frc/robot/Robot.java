package frc.robot;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Robot extends TimedRobot {

  // Motores lanzamiento
  private final Spark motorArribaLanzamiento = new Spark(0); // Puerto PWM 0
  private final Spark motorAbajoLanzamiento = new Spark(1); // Puerto PWM 1
  
  // Motores Enganche
  private final Spark motorLeftEnganche =new Spark(6); // Puerto PWM 2
  private final Spark motorRightEnganche =new Spark(7); // Puerto PWM 3

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

  //MOVIMIENTO
  //Motores movimiento
  private Spark motorAdelanteIzquierdaMovimiento = new Spark(2); //Puerto PWM 2
  private Spark motorAdelanteDerechaMovimiento = new Spark(3); //Puerto PWM 3
  private Spark motorAtrasIzquierdaMovimiento = new Spark(4); //Puerto PWM 4
  private Spark motorAtrasDerechaMovimiento = new Spark(5); //Puerto PWM 5

  //RECOLECCIÓN
  // Motores de recolección
  private Spark motorArribaRecoleccion = new Spark(6); //Puerto PWM 6
  private Spark motorAbajoRecoleccion = new Spark(7); //Puerto PWM 7

  @Override
  public void robotinit () {
    Recoleccion.recoleccionPeriodico(Spark motorAbajoRecoleccion, Spark motorArribaRecoleccion);
  }
  @Override
  public void robotPeriodic() {
    //esto se esta actualizando todo el tiempo
    hayDisco = sensorDisco.get(); // true si el sensor detecta el disco, false si no
  }

  @Override
  public void teleopPeriodic() {
    Lanzamiento.lanzamientoPeriodico(motorArribaLanzamiento, motorAbajoLanzamiento, joystick, botonActivarTiro, botonDisparoForzado, timer, estanActivos, sensorDisco, hayDisco);
    Movimiento.movimientoPeriodico(joystick, motorAdelanteIzquierdaMovimiento, motorAdelanteDerechaMovimiento, motorAtrasIzquierdaMovimiento, motorAtrasDerechaMovimiento);
    Recoleccion.recoleccionPeriodico(null, null);
    Enganche.enganchePeriodico(joystick, motorLeftEnganche, motorRightEnganche);

  }
}