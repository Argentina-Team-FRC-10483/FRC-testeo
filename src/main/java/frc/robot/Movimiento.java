package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Movimiento {
    public static void movimientoPeriodico(Joystick joystick, Spark motorAdelanteIzquierdaMovimiento, Spark motorAdelanteDerechaMovimiento, Spark motorAtrasIzquierdaMovimiento, Spark motorAtrasDerechaMovimiento){

        double speed = -joystick.getRawAxis(1) * 0.6;
        double turn = joystick.getRawAxis(4) * 0.3;
    
        double left = speed + turn;
        double right = speed - turn;
    
        motorAdelanteDerechaMovimiento.set(left);
        motorAdelanteIzquierdaMovimiento.set(left);
        motorAtrasDerechaMovimiento.set(-right);
        motorAtrasIzquierdaMovimiento.set(-right);
    }
}
