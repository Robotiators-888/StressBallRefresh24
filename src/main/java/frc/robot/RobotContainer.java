package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IndexSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();

  // Creates joystick and joystick objects
  public final Joystick joystick = new Joystick(Constants.JOYSTICK_PORT);
  public final JoystickButton aButton = new JoystickButton(joystick, 1);
  public final JoystickButton bButton = new JoystickButton(joystick, 2);
  public final JoystickButton rBumper = new JoystickButton(joystick, 6);
  public final JoystickButton lBumper = new JoystickButton(joystick, 5);

  Trigger rightTrigger = new Trigger(() -> (joystick.getRawAxis(3) > 0.5));

  public RobotContainer() {
    configureButtonBindings();

    driveSubsystem
        .setDefaultCommand(
            new RunCommand(
                () -> driveSubsystem.setMotors(joystick.getRawAxis(Constants.RIGHT_AXIS),
                    joystick.getRawAxis(Constants.LEFT_AXIS), Constants.DRIVE_SPEED),
                driveSubsystem));

  }



  private void configureButtonBindings() {
    rightTrigger.whileTrue(new RunCommand(() -> IndexSubsystem.ShootFullSpeed()));
    rightTrigger.whileTrue(new RunCommand(()->ShooterSubsystem.flywheelSpeed(Constants.FLYWHEELSHOOTSPEED)));
  }

  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
