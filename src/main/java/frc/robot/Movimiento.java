package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Movimiento {
    public static void movimientoPeriodico(Joystick joystick, Spark motorAdelanteIzquierdaMovimiento, Spark motorAdelanteDerechaMovimiento, Spark motorAtrasIzquierdaMovimiento, Spark motorAtrasDerechaMovimiento){
        final double deadzone = 0.3; //deadzone modificable para el raw movement del joystick
        
        double rawVelocidad = -joystick.getRawAxis(1); //el negativo significa que arriba es negativo y abajo es positivo
        double rawGiro = joystick.getRawAxis(4);

        double velocidad = (Math.abs(rawVelocidad) > deadzone) ? -rawVelocidad * 0.6 : 0; // if statement para checkear que el rawmovement del joystick no sea menor que la deadzone
        double giro = (Math.abs(rawGiro) > deadzone) ? rawGiro * 0.3 : 0; // if statement para checkear que el rawgiro del joystick no sea menor que la deadzone

        /*
        double izquierda = velocidad + giro;
        double derecha = velocidad - giro;
    
        motorAdelanteDerechaMovimiento.set(izquierda);
        motorAdelanteIzquierdaMovimiento.set(izquierda);
        motorAtrasDerechaMovimiento.set(-derecha);
        motorAtrasIzquierdaMovimiento.set(-derecha);
        */

        
        //Otra forma (hay que probar ambas)
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
        
    }
}
