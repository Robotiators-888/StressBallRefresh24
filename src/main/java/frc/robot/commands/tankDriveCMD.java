//888 robotiators 2021

package frc.robot.commands;
import frc.robot.subsystems.DriveSubsystem;
import java.util.function.Supplier;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

// class of tankDriveCMD
public class tankDriveCMD extends Command {

  //creates driveSubsystem object from the DriveSubsystem class/file
  private final DriveSubsystem driveSubsystem;
  //creates a lamda expression that lets us grab the true value of objects and not a just static value
  private Supplier<Double> speedLeft, speedRight, speed;
  
 
  // The construtor of the cmd, it gets the requirements it needs to full run the command, this will later be called in RobotContainer 
  public tankDriveCMD(DriveSubsystem driveSubsystem, Supplier<Double> speedLeft, Supplier<Double> speedRight, 
      Supplier<Double> speed2) {
    this.driveSubsystem = driveSubsystem;
    this.speedLeft = speedLeft;
    this.speedRight = speedRight;
    this.speed = speed2;

    addRequirements(driveSubsystem);
  }
 
  //when the CMD starts this will run once
  public void initialize() {}

  //One the CMD starts this will run until the CMD is interrupted or the robot exits enabled
  public void execute() {
    //Gets speeds of the left and right sides plus the overall speed
    driveSubsystem.setMotors(speedLeft.get(), speedRight.get(), speed.get());
    
    //sends the data to the smart dash which can be seen on the driver station
    SmartDashboard.putNumber("Left side speed",speedLeft.get());
    SmartDashboard.putNumber("Right side speed",speedRight.get());
    SmartDashboard.putNumber("speed",speed.get());
  }

  public void end(boolean interrupted) {}

  public boolean isFinished() {
    return false;
  }
}
