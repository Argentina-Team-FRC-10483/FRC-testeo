package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Movimiento {
    public static void movimientoPeriodico(Joystick joystick, Spark motorAdelanteIzquierdaMovimiento, Spark motorAdelanteDerechaMovimiento, Spark motorAtrasIzquierdaMovimiento, Spark motorAtrasDerechaMovimiento){

        double velocidad = -joystick.getRawAxis(1) * 0.6; //el negativo significa que arriba es negativo y abajo es positivo
        double giro = joystick.getRawAxis(4) * 0.3; //lo que se multiplica es para bajar la velocidad y el giro para que sea mas manejable
    
        double izquierda = velocidad + giro;
        double derecha = velocidad - giro;
    
        motorAdelanteDerechaMovimiento.set(izquierda);
        motorAdelanteIzquierdaMovimiento.set(izquierda);
        motorAtrasDerechaMovimiento.set(-derecha);
        motorAtrasIzquierdaMovimiento.set(-derecha);

        /* 
        Otra forma (hay que probar ambas)
        // Calcular velocidades para cada rueda
        double motorAdelanteIzquierdaVelocidad = velocidad + giro;  // Avanza y gira
        double motorAtrasIzquierdaVelocidad = velocidad - giro;     // Avanza y contragira
        double motorAdelanteDerechaVelocidad = velocidad - giro;    // Avanza y contragira
        double motorAtrasDerechaVelocidad = velocidad + giro;       // Avanza y gira

        // Asignar las velocidades a los motores
        motorAdelanteIzquierdaMovimiento.set(motorAdelanteIzquierdaVelocidad);
        motorAtrasIzquierdaMovimiento.set(motorAtrasIzquierdaVelocidad);
        motorAdelanteDerechaMovimiento.set(-motorAdelanteDerechaVelocidad); // Invertido por montaje físico
        motorAtrasDerechaMovimiento.set(-motorAtrasDerechaVelocidad);       // Invertido por montaje físico
        */
    }
}3
