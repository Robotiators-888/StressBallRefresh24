package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.HoodSubsystem;
import frc.robot.subsystems.IndexSubsystem;
import frc.robot.subsystems.ShooterSubsystem;


public class RobotContainer {
        // The robot's subsystems are defined here...
        private static final DriveSubsystem driveSubsystem = new DriveSubsystem();
        private static final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
        private static final IndexSubsystem indexSubsystem = new IndexSubsystem();
        private static final HoodSubsystem hoodSubsystem = new HoodSubsystem();

        // Creates joystick and joystick objects
        public final Joystick joystick = new Joystick(Constants.JOYSTICK_PORT);
        public final JoystickButton aButton = new JoystickButton(joystick, 1);
        public final JoystickButton bButton = new JoystickButton(joystick, 2);
        public final JoystickButton xButton = new JoystickButton(joystick, 3);
        public final JoystickButton yButton = new JoystickButton(joystick, 4);
        public final JoystickButton lBumper = new JoystickButton(joystick, 5);
        public final JoystickButton rBumper = new JoystickButton(joystick, 6);
        public final JoystickButton startButton = new JoystickButton(joystick, 7);

        Trigger rightTrigger = new Trigger(() -> (joystick.getRawAxis(3) > 0.5));
        Trigger leftTrigger = new Trigger(() -> (joystick.getRawAxis(4) > 0.5));

        public RobotContainer() {
                configureButtonBindings();

                driveSubsystem.setDefaultCommand(new RunCommand(() -> driveSubsystem.setMotors(
                                joystick.getRawAxis(Constants.RIGHT_AXIS),
                                joystick.getRawAxis(Constants.LEFT_AXIS), Constants.DRIVE_SPEED),
                                driveSubsystem));



        }

        private void configureButtonBindings() {

                rightTrigger.whileTrue(new ParallelCommandGroup(
                                new RunCommand(() -> indexSubsystem.indexFullSpeed(),
                                                indexSubsystem),
                                new RunCommand(() -> shooterSubsystem
                                                .flywheelSpeed(Constants.FLYWHEELSHOOTSPEED),
                                                shooterSubsystem)))
                                .onFalse(new InstantCommand(() -> indexSubsystem.stopAll()));

                leftTrigger.whileTrue(
                                new RunCommand(() -> indexSubsystem.indexOneBall(), indexSubsystem)
                                                .until(() -> indexSubsystem.indexBannerSensor())
                                                .andThen(new SequentialCommandGroup(new InstantCommand(
                                                                () -> indexSubsystem.setIndexSpeed(Constants.SINGLEBALL_SPEED_INDEX)),
                                                                new WaitCommand(.3),
                                                                 new InstantCommand(()-> indexSubsystem.stopAll()))));

                aButton.toggleOnTrue(Commands.startEnd(
                                () -> shooterSubsystem.flywheelSpeed(Constants.FLYWHEELSHOOTSPEED),
                                () -> shooterSubsystem.flywheelSpeed(0), shooterSubsystem));
        }



        public Command getAutonomousCommand() {
                return null;
        }
}
