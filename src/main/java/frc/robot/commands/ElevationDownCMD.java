package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;



public class ElevationDownCMD extends Command{
    private final ShooterSubsystem shooterSubsystem;
    private final Supplier<Integer> ElevationDown;

    // Constructor of the cmd that creates the ability to move elevation down
    public ElevationDownCMD(ShooterSubsystem shooterSubsystem, Supplier<Integer> ElevationDown){
        this.shooterSubsystem = shooterSubsystem;
        this.ElevationDown = ElevationDown;
   
        addRequirements(shooterSubsystem);
    }


// Called when the command is initially scheduled.
@Override
public void initialize() {}

// Called every time the scheduler runs while the command is scheduled.
@Override
public void execute() {
   shooterSubsystem.elevationDown();
}

// Called once the command ends or is interrupted.
@Override
public void end(boolean interrupted) {
  shooterSubsystem.elevationEnd();
}

// Returns true when the command should end.
@Override
public boolean isFinished() {
  return false;
}
}

