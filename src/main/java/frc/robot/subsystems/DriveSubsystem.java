package frc.robot.subsystems;


import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  // create motor controller objects
  private static CANSparkMax leftPrimary = new CANSparkMax(Constants.CANID_LEFT_PRIMARY, MotorType.kBrushless);
  private static CANSparkMax rightPrimary = new CANSparkMax(Constants.CANID_RIGHT_PRIMARY, MotorType.kBrushless);
  private static CANSparkMax leftSecondary = new CANSparkMax(Constants.CANID_LEFT_SECONDARY, MotorType.kBrushless);
  private static CANSparkMax rightSecondary = new CANSparkMax(Constants.CANID_RIGHT_SECONDARY, MotorType.kBrushless);
  private static DifferentialDrive driveTrain = new DifferentialDrive(leftPrimary, rightPrimary);
  // create a speed controller group for each side

  // create a drive train group with the speed controller groups
 

  public DriveSubsystem() {
    // set one motor on each side inverted so we dont destroy the gearbox

    // leftSecondary.setInverted(true);
    // rightSecondary.setInverted(true);

    // configure following of primary motors by secondary motors
    leftSecondary.follow(leftPrimary);
    rightSecondary.follow(rightPrimary);
  }

  public void periodic() {

  }

  /**
   * Sets speed of the motors in the drivetrain
   * 
   * @param leftSpeed  Speed of the left drivetrain
   * @param rightSpeed Speed of right drivetrain
   * @param driveSpeed Set a percentage of max speed the robot can use
   */
  public void setMotors(double leftSpeed, double rightSpeed, double driveSpeed) {
    driveTrain.arcadeDrive(leftSpeed * driveSpeed, rightSpeed * -driveSpeed);
  }
}