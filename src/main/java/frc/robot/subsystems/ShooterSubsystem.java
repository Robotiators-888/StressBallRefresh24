package frc.robot.subsystems;
import com.revrobotics.spark.SparkMax;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
   private static ShooterSubsystem INSTANCE = null;
   //private static SparkMax FlywheelMotor = new SparkMax(Constants.CANID_SHOOT_MOTOR,MotorType.kBrushless);
   private SparkMax FlywheelMotor;
   public void periodic() {
      SmartDashboard.putNumber("FlywheelRPM", flywheelRPM());
   }

   public double flywheelRPM(){
      return -FlywheelMotor.getEncoder().getVelocity();
   }

   public boolean atdesiredRPM() {
      return flywheelRPM() >= Constants.SHOOT_THRESHOLD_RPM - 100;
   }

   public void flywheelSpeed(double speed) {
      FlywheelMotor.set(speed);
   }

   public static ShooterSubsystem getInstance () {
      if (INSTANCE==null) {
         INSTANCE = new ShooterSubsystem();
         return INSTANCE;
      }
      else {
         return INSTANCE;
      }
   }

   private ShooterSubsystem () {
      FlywheelMotor = new SparkMax(Constants.CANID_SHOOT_MOTOR,MotorType.kBrushed);
   }
}