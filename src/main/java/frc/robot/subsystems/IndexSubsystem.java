package frc.robot.subsystems;

import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IndexSubsystem extends SubsystemBase{
    private static WPI_TalonSRX Index = new WPI_TalonSRX(Constants.CANID_INDEX_MOTOR);
    private static DigitalInput BannerSensor = new DigitalInput(Constants.DIO_BANNER_INPUT);
    
    public void setIndexSpeed(double speed){
        Index.set(speed);
    }


    public void indexFullSpeed() {
        setIndexSpeed(Constants.FULL_SPEED_INDEX);
    }

    public void indexOneBall(){         
        setIndexSpeed(Constants.SINGLEBALL_SPEED_INDEX);
    }

    public void stopAll(){
        setIndexSpeed(0);
    }
    
    public boolean indexBannerSensor(){
        return BannerSensor.get();
    }

    public void periodic() {
        SmartDashboard.putBoolean("BannerSensor", indexBannerSensor());

    }
 
}