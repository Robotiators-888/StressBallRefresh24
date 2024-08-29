
package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  // create motor controller objects
  private WPI_VictorSPX leftPrimary = new  WPI_VictorSPX(Constants.ID_LEFT_PRIMARY);
  private WPI_VictorSPX leftSecondary = new WPI_VictorSPX(Constants.ID_LEFT_SECONDARY);
  private WPI_VictorSPX rightPrimary = new WPI_VictorSPX(Constants.ID_RIGHT_PRIMARY);
  private WPI_VictorSPX rightSecondary = new WPI_VictorSPX(Constants.ID_RIGHT_SECONDARY);
  private DifferentialDrive driveTrain = new DifferentialDrive(leftPrimary, rightPrimary);
  // create a speed controller group for each side

  // create a drive train group with the speed controller groups
 

  public DriveSubsystem() {
    // set one motor on each side inverted so we dont destroy the gearbox
    
    leftSecondary.follow(leftPrimary);
    rightSecondary.follow(rightPrimary);
    // leftSecondary.setInverted(true);
    // rightSecondary.setInverted(true);
  }

  public void periodic() {

  }

  /**
   * Sets speed of the motors in the drivetrain
   * 
   * @param leftSpeed  Speed of the left drivetrain
   * @param rightSpeed Speed of right drivetrain
   * @param Speed      set a precentage of max speed the robot can use
   */
  public void setMotors(double leftSpeed, double rightSpeed, double Speed) {
    driveTrain.arcadeDrive(leftSpeed * 0.6, rightSpeed * -0.6);
  }
}
