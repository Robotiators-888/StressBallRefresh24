package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class ShooterSubsystem extends SubsystemBase {
   Spark FlywheelLeft = new Spark(Constants.FLYWHEEL_LEFT);
   Spark FlywheelRight = new Spark(Constants.FLYWHEEL_RIGHT);
   Spark elevation = new Spark(Constants.ELEVATION);
   double flywheelSpeed = Constants.FLYWHEEL_SPEED;
   double elevationSpeed = Constants.ELEVATION_SPEED;

   MotorControllerGroup FlywheelGroup = new MotorControllerGroup(FlywheelLeft, FlywheelRight);

   public void periodic() {

   }

   //

   public void flywheelSpeed() {
      FlywheelRight.set(Constants.FLYWHEEL_SPEED * -1);
      FlywheelLeft.set(Constants.FLYWHEEL_SPEED);

   }

   public void flywheelEnd() {
      FlywheelLeft.set(0.0);
      FlywheelRight.set(0.0);
   }

   //
   public void elevationUp() {
      elevationSpeed = Constants.FLYWHEEL_SPEED;
      elevation.set(elevationSpeed);
   }

   public void elevationDown() {
      elevationSpeed = Constants.FLYWHEEL_SPEED * -1;
      elevation.set(elevationSpeed);
   }

   public void elevationEnd() {
      elevationSpeed = 0;
      elevation.set(0.0);
   }

}
