package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {

  @Override
  public void robotInit(){
    new RobotContainer();
  }

  @Override
  public void teleopInit() {}
  
  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void autonomousInit() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  @Override
  public void disabledInit() {}
  
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void teleopPeriodic() {}

  @Override
  public void autonomousPeriodic() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}

  @Override
  public void disabledPeriodic() {}
}
