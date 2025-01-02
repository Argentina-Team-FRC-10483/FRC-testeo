package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Movimiento {
    private static final double deadzone = 0.3; // Variable q determina la deadzone
    private static final double escalaVelocidad = 0.6; // valor para mult la velocidad
    private static final double escalaGiro = 0.3; // valor para mult el giro

    public static void movimientoPeriodico(Joystick joystick, Spark motorAdelanteIzquierdaMovimiento, Spark motorAdelanteDerechaMovimiento, Spark motorAtrasIzquierdaMovimiento, Spark motorAtrasDerechaMovimiento){
        double velocidad = aplicarDeadzone(-joystick.getRawAxis(1), deadzone) * escalaVelocidad; // se aplica la deadzone al raw reading del joystick y se multiplica por escalaVelocidad
        double giro = aplicarDeadzone(joystick.getRawAxis(4), deadzone) * escalaGiro; // lo mismo que antes pero con escalaGiro

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
        double motorAdelanteIzquierdaVelocidad = calcularVelocidadMotor(velocidad, giro, false); //usa una funcion para calcular la velocidad del motor y determina la orientación
        double motorAtrasIzquierdaVelocidad = calcularVelocidadMotor(velocidad, -giro, false); // lo mismo
        double motorAdelanteDerechaVelocidad = calcularVelocidadMotor(velocidad, -giro, true); // lo mismo
        double motorAtrasDerechaVelocidad = calcularVelocidadMotor(velocidad, giro, true); // lo mismo

        // Asignar las velocidades a los motores
        motorAdelanteIzquierdaMovimiento.set(motorAdelanteIzquierdaVelocidad);
        motorAtrasIzquierdaMovimiento.set(motorAtrasIzquierdaVelocidad);
        motorAdelanteDerechaMovimiento.set(-motorAdelanteDerechaVelocidad); // Invertido por montaje físico
        motorAtrasDerechaMovimiento.set(-motorAtrasDerechaVelocidad);       // Invertido por montaje físico
        
    }

    private static double aplicarDeadzone(double valor, double deadzone) { 
        return (Math.abs(valor) > deadzone) ? valor : 0; // si el numero es mayor a la deadzone devuelve el reading, si no devuelve 0
    }

    private static double calcularVelocidadMotor(double velocidad, double giro, boolean invertir) {
        return invertir ? -(velocidad + giro) : (velocidad + giro); // calcula la velocidad del motor y lo invierte de ser necesario perroo
    }
}
