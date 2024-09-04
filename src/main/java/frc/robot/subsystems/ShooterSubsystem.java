package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class ShooterSubsystem extends SubsystemBase {
   static CANSparkMax Shoot = new CANSparkMax(Constants.ID_SHOOT_MOTOR, MotorType.kBrushless);

   public void periodic() {

   }

   public static void flywheelSpeed(double speed) {
      Shoot.set(speed);
   }

   public void flywheelEnd() {

   }

   public void elevationUp() {

   }

   public void elevationDown() {

   }

   public void elevationEnd() {

   }

}
