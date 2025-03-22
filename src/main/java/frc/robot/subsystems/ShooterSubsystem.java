package frc.robot.subsystems;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
   private static SparkMax FlywheelMotor = new SparkMax(Constants.CANID_SHOOT_MOTOR,MotorType.kBrushless);
   
   public void periodic() {
      SmartDashboard.putNumber("FlywheelRPM", flywheelRPM());
   }

   public static double flywheelRPM(){
      return -FlywheelMotor.getEncoder().getVelocity();
   }

   public boolean atdesiredRPM() {
      return flywheelRPM() >= Constants.SHOOT_THRESHOLD_RPM - 100;
   }

   public void flywheelSpeed(double speed) {
      FlywheelMotor.set(speed);
   }
}