package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class ShooterSubsystem extends SubsystemBase {
   static CANSparkMax FlywheelMotor = new CANSparkMax(Constants.CANID_SHOOT_MOTOR,MotorType.kBrushless);
      
   ;
   public void periodic() {

   }

   public static void flywheelSpeed(double speed) {
      FlywheelMotor.set(speed);
   }
}
