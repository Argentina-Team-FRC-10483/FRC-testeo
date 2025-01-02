package frc.robot.subsistemas;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Enganche extends SubsystemBase{
    private Spark motorLeftEnganche = new Spark(8); // Puerto PWM 8
    private Spark motorRightEnganche = new Spark(9); // Puerto PWM 9

    public void elevar(){   
        motorLeftEnganche.set(0);
        motorRightEnganche.set(0);
        motorLeftEnganche.set(0);
        motorRightEnganche.set(0);
    }

    public void elevar(double vel, double dirreccion){   
        motorLeftEnganche.set(vel + dirreccion);
        motorRightEnganche.set(vel + dirreccion);
        motorLeftEnganche.set(vel - dirreccion);
        motorRightEnganche.set(vel - dirreccion);
    }
}
