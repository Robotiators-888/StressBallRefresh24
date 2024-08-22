// Copyright 2021-2024 FRC 6328
// http://github.com/Mechanical-Advantage
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// version 3 as published by the Free Software Foundation or
// available in the root directory of this project.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.

package frc.robot.subsystems.flywheel;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class FlywheelIOSim implements FlywheelIO {
  private FlywheelSim sim = new FlywheelSim(DCMotor.getNEO(1), 1.5, 0.004);

  @Override
  public void updateInputs(FlywheelIOInputs inputs) {

    sim.update(0.02);
  }

  @Override
  public void set(double speed) {
    sim.set(speed);
  }

  @Override
  public void stop() {
    set(0.0);
  }
}
