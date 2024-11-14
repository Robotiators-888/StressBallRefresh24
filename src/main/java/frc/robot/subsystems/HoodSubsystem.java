package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HoodSubsystem extends SubsystemBase {
   private static Solenoid hood = new Solenoid(PneumaticsModuleType.REVPH, 0);

   
   public void periodic() {

   }
   public void hoodUp() {
      hood.set(true);
   }
   public void hoodDown() {
      hood.set(false);
   }
   
}