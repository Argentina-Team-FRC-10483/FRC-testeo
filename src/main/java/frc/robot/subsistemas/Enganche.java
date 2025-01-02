package frc.robot.subsistemas;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Enganche {
    public static void enganchePeriodico(Joystick joystick,Spark motorLeftEnganche, Spark motorRightEnganche){
        double vel = joystick.getRawAxis(2) * 0.5;
        double dirrec = joystick.getRawAxis(3) * 0.5;

        double Top = vel + dirrec;
        double Bottom = vel - dirrec;

        motorLeftEnganche.set(Top);
        motorRightEnganche.set(Top);
        motorLeftEnganche.set(Bottom);
        motorRightEnganche.set(Bottom);
    }
}
