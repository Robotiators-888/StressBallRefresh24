package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  private static DriveSubsystem INSTANCE = null;
  // create motor controller objects
  private static WPI_VictorSPX leftPrimary;
  private static WPI_VictorSPX rightPrimary;
  private static WPI_VictorSPX leftSecondary;
  private static WPI_VictorSPX rightSecondary;
  private static DifferentialDrive driveTrain;
  // create a speed controller group for each side

  // create a drive train group with the speed controller groups

  public void periodic() {

  }

  /**
   * Sets speed of the motors in the drivetrain
   * 
   * @param leftSpeed Speed of the left drivetrain
   * @param rightSpeed Speed of right drivetrain
   * @param driveSpeed Set a percentage of max speed the robot can use
   */
  public void setMotors(double leftSpeed, double rightSpeed, double driveSpeed) {
    driveTrain.arcadeDrive(leftSpeed * driveSpeed, rightSpeed * -driveSpeed);
  }

  public static DriveSubsystem getInstance () {
    if (INSTANCE==null) {
       INSTANCE = new DriveSubsystem();
       return INSTANCE;
    }
    else {
       return INSTANCE;
    }
 }

 private DriveSubsystem () {
  leftPrimary = new WPI_VictorSPX(Constants.CANID_LEFT_PRIMARY);
  rightPrimary = new WPI_VictorSPX(Constants.CANID_RIGHT_PRIMARY);
  leftSecondary = new WPI_VictorSPX(Constants.CANID_LEFT_SECONDARY);
  rightSecondary = new WPI_VictorSPX(Constants.CANID_RIGHT_SECONDARY);
  driveTrain = new DifferentialDrive(leftPrimary, rightPrimary);
    // set one motor on each side inverted so we dont destroy the gearbox

    // leftSecondary.setInverted(true);
    // rightSecondary.setInverted(true);

    // configure following of primary motors by secondary motors
    leftSecondary.follow(leftPrimary);
    rightSecondary.follow(rightPrimary);
 }
}
