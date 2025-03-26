package frc.robot;

import edu.wpi.first.math.MathUtil;
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
import frc.robot.subsystems.IndexSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class RobotContainer {
        // The robot's subsystems are defined here...
        private static final DriveSubsystem driveSubsystem = new DriveSubsystem();
        private static final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
        private static final IndexSubsystem indexSubsystem = new IndexSubsystem();

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
        Trigger leftTrigger = new Trigger(() -> (joystick.getRawAxis(2) > 0.5));

        public RobotContainer() {
                configureButtonBindings();

                driveSubsystem.setDefaultCommand(new RunCommand(() -> driveSubsystem.setMotors(
                                Math.pow(MathUtil.applyDeadband(
                                                joystick.getRawAxis(Constants.RIGHT_AXIS), .05), 1),
                                Math.pow(MathUtil.applyDeadband(
                                                -joystick.getRawAxis(Constants.LEFT_AXIS), .05), 1),
                                Constants.DRIVE_SPEED), driveSubsystem));
                shooterSubsystem.setDefaultCommand(new RunCommand(
                                () -> shooterSubsystem.flywheelSpeed(0), shooterSubsystem));
                indexSubsystem.setDefaultCommand(
                                new RunCommand(() -> indexSubsystem.stopAll(), indexSubsystem));
        }

        private void configureButtonBindings() {

                rightTrigger.whileTrue(new SequentialCommandGroup(new RunCommand(
                                () -> shooterSubsystem.flywheelSpeed(Constants.FLYWHEELSHOOTSPEED),
                                shooterSubsystem)
                                                .until(() -> shooterSubsystem.atdesiredRPM())
                                                .andThen(new RunCommand(
                                                                () -> indexSubsystem
                                                                                .indexFullSpeed(),
                                                                indexSubsystem))))
                                .onFalse(new InstantCommand(() -> indexSubsystem.stopAll(),
                                                indexSubsystem));
                //leftTrigger.whileTrue(new RunCommand(() -> indexSubsystem.setIndexSpeed(Constants.SINGLEBALL_SPEED_INDEX), indexSubsystem));
                
                leftTrigger.onTrue(
                                new SequentialCommandGroup(
                                        new InstantCommand(() -> indexSubsystem.setIndexSpeed(Constants.SINGLEBALL_TIMED_SPEED_INDEX), indexSubsystem),
                                        new WaitCommand(Constants.SINGLEBALL_TIME_INDEX)));

                // leftTrigger.onTrue(new SequentialCommandGroup(new RunCommand(
                // () -> indexSubsystem.indexOneBall(), indexSubsystem)
                // .until(() -> indexSubsystem.indexBannerSensor())
                // .andThen(new SequentialCommandGroup(
                // new InstantCommand(
                // () -> indexSubsystem
                // .setIndexSpeed(Constants.SINGLEBALL_SPEED_INDEX)),
                // new WaitCommand(.2),
                // new InstantCommand(
                // () -> indexSubsystem
                // .stopAll())))));

                aButton.toggleOnTrue(Commands.startEnd(
                                () -> shooterSubsystem.flywheelSpeed(Constants.FLYWHEELSHOOTSPEED),
                                () -> shooterSubsystem.flywheelSpeed(0), shooterSubsystem));

        }

        public Command getAutonomousCommand() {
                return null;
        }
}
