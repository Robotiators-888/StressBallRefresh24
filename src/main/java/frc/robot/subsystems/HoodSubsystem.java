package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class HoodSubsystem extends SubsystemBase {
   private static CANSparkMax HoodMotor = new CANSparkMax(Constants.CANID_HOOD_MOTOR,MotorType.kBrushless);

   
   public void periodic() {
   }

   public static void flywheelSpeed(double speed) {
      HoodMotor.set(speed);
   }
}