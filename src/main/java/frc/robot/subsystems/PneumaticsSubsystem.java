package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticsSubsystem extends SubsystemBase {

    // Solenoid constructor is (6,7) the 6 is the solenoid input, 7 is solenoid
    // output
    DoubleSolenoid piston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 6, 7);
    Compressor c = new Compressor(PneumaticsModuleType.CTREPCM);
    
    public PneumaticsSubsystem(){
        piston.set(Value.kReverse);
    }

    // Causes Piston to fire forward
    public void pistonGo() {
        piston.set(Value.kForward);
    }

    // Causes Piston to return to unfired position
    public void PistonReverse() {
        piston.set(Value.kReverse);
    }

    // toggles the piston to fire again
    public void PistonToggle() {
        piston.toggle();
    }

    public void periodic() {

    }

}
