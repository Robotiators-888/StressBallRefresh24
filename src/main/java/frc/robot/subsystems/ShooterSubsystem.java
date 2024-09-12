package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class ShooterSubsystem extends SubsystemBase {
   private static CANSparkMax FlywheelMotor = new CANSparkMax(Constants.CANID_SHOOT_MOTOR,MotorType.kBrushless);

   
   public void periodic() {
      SmartDashboard.putNumber("FlywheelRPM", flywheelRPM());
   }

   public static double flywheelRPM(){
      return FlywheelMotor.getEncoder().getVelocity();
   }

   public static void flywheelSpeed(double speed) {
      FlywheelMotor.set(speed);
   }
}