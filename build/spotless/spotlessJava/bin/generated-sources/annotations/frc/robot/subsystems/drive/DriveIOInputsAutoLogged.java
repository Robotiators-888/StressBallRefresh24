package frc.robot.subsystems.drive;

import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public class DriveIOInputsAutoLogged extends DriveIO.DriveIOInputs
    implements LoggableInputs, Cloneable {
  @Override
  public void toLog(LogTable table) {
    table.put("LeftPositionRad", leftPositionRad);
    table.put("LeftVelocityRadPerSec", leftVelocityRadPerSec);
    table.put("LeftAppliedVolts", leftAppliedVolts);
    table.put("LeftCurrentAmps", leftCurrentAmps);
    table.put("RightPositionRad", rightPositionRad);
    table.put("RightVelocityRadPerSec", rightVelocityRadPerSec);
    table.put("RightAppliedVolts", rightAppliedVolts);
    table.put("RightCurrentAmps", rightCurrentAmps);
    table.put("GyroYaw", gyroYaw);
  }

  @Override
  public void fromLog(LogTable table) {
    leftPositionRad = table.get("LeftPositionRad", leftPositionRad);
    leftVelocityRadPerSec = table.get("LeftVelocityRadPerSec", leftVelocityRadPerSec);
    leftAppliedVolts = table.get("LeftAppliedVolts", leftAppliedVolts);
    leftCurrentAmps = table.get("LeftCurrentAmps", leftCurrentAmps);
    rightPositionRad = table.get("RightPositionRad", rightPositionRad);
    rightVelocityRadPerSec = table.get("RightVelocityRadPerSec", rightVelocityRadPerSec);
    rightAppliedVolts = table.get("RightAppliedVolts", rightAppliedVolts);
    rightCurrentAmps = table.get("RightCurrentAmps", rightCurrentAmps);
    gyroYaw = table.get("GyroYaw", gyroYaw);
  }

  public DriveIOInputsAutoLogged clone() {
    DriveIOInputsAutoLogged copy = new DriveIOInputsAutoLogged();
    copy.leftPositionRad = this.leftPositionRad;
    copy.leftVelocityRadPerSec = this.leftVelocityRadPerSec;
    copy.leftAppliedVolts = this.leftAppliedVolts;
    copy.leftCurrentAmps = this.leftCurrentAmps.clone();
    copy.rightPositionRad = this.rightPositionRad;
    copy.rightVelocityRadPerSec = this.rightVelocityRadPerSec;
    copy.rightAppliedVolts = this.rightAppliedVolts;
    copy.rightCurrentAmps = this.rightCurrentAmps.clone();
    copy.gyroYaw = this.gyroYaw;
    return copy;
  }
}
