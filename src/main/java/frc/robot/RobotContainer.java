package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IndexSubsystem;
import frc.robot.subsystems.ShooterSubsystem;


public class RobotContainer {
  // The robot's subsystems are defined here...
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final IndexSubsystem indexSubsystem = new IndexSubsystem();

  // Creates joystick and joystick objects
  public final Joystick joystick = new Joystick(Constants.JOYSTICK_PORT);
  public final JoystickButton aButton = new JoystickButton(joystick, 1);
  public final JoystickButton bButton = new JoystickButton(joystick, 2);
  public final JoystickButton rBumper = new JoystickButton(joystick, 6);
  public final JoystickButton lBumper = new JoystickButton(joystick, 5);

  Trigger rightTrigger = new Trigger(() -> (joystick.getRawAxis(3) > 0.5));
  Trigger leftTrigger = new Trigger(() -> (joystick.getRawAxis(4) > 0.5));

  public RobotContainer() {
    configureButtonBindings();

    driveSubsystem
        .setDefaultCommand(
            new RunCommand(
                () -> driveSubsystem.setMotors(joystick.getRawAxis(Constants.RIGHT_AXIS),
                    joystick.getRawAxis(Constants.LEFT_AXIS), Constants.DRIVE_SPEED),
                driveSubsystem));

    rightTrigger
        .whileTrue(new ParallelCommandGroup(
            new RunCommand(() -> IndexSubsystem.indexFullSpeed(), indexSubsystem),
            new RunCommand(() -> ShooterSubsystem.flywheelSpeed(Constants.FLYWHEELSHOOTSPEED), shooterSubsystem)))
        .onFalse(new InstantCommand(() -> IndexSubsystem.stopAll()));

    leftTrigger.onTrue(new RunCommand(() -> IndexSubsystem.indexOneBall(), indexSubsystem)
        .until(() -> IndexSubsystem.indexBannerSensor())
        .andThen(new InstantCommand(() -> IndexSubsystem.stopAll())));

    aButton.toggleOnTrue(
        Commands.startEnd(() -> ShooterSubsystem.flywheelSpeed(Constants.FLYWHEELSHOOTSPEED),
            () -> ShooterSubsystem.flywheelSpeed(0), shooterSubsystem));



  }

  private void configureButtonBindings() {}

  public Command getAutonomousCommand() {
    return null;
  }
}
