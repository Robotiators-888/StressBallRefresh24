package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IndexSubsystem extends SubsystemBase{
    private static Spark Index = new Spark(Constants.DIO_INDEX_MOTOR);
    private static Spark Spin = new Spark(Constants.DIO_FEED_MOTOR);
    private static DigitalInput BannerSensor = new DigitalInput(Constants.DIO_BANNER_INPUT);
    
    public void setIndexSpeed(double speed){
        Index.set(speed);
    }
    
    public static void setSpinSpeed(double speed){
        Spin.set(speed);
    }

    public void indexFullSpeed() {
        setSpinSpeed(Constants.FULL_SPEED_SPIN);
        setIndexSpeed(Constants.FULL_SPEED_INDEX);
    }

    public void indexOneBall(){         
        setSpinSpeed(Constants.SINGLEBALL_SPEED_SPIN);
        setIndexSpeed(Constants.SINGLEBALL_SPEED_INDEX);
    }

    public void stopAll(){
        setSpinSpeed(0);
        setIndexSpeed(0);
    }
    
    public boolean indexBannerSensor(){
        return BannerSensor.get();
    }

    public void periodic() {

    }
 
}