package frc.robot.subsystems;

import frc.robot.Constants;
import java.util.function.BooleanSupplier;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IndexSubsystem extends SubsystemBase{
    private static Spark Index = new Spark(Constants.DIO_INDEX_MOTOR);
    private static Spark Feed = new Spark(Constants.DIO_FEED_MOTOR);
    public static DigitalInput BannerSensor = new DigitalInput(Constants.DIO_BANNER_INPUT);
    public static BooleanSupplier indexBannerSensor;
    public static void setIndexSpeed(double speed){
        Index.set(speed);
    }
    
    public static void setFeedSpeed(double speed){
        Feed.set(speed);
    }

    public static void indexFullSpeed() {
        setFeedSpeed(Constants.FULL_SPEED_FEED);
        setIndexSpeed(Constants.FULL_SPEED_INDEX);
    }

    public static void indexOneBall(){         
        setFeedSpeed(Constants.FULL_SPEED_FEED);
        setIndexSpeed(Constants.FULL_SPEED_INDEX);
    }

    public static void stopAll(){
        setFeedSpeed(0);
        setIndexSpeed(0);
    }
    
    public boolean indexBannerSensor(){
        return BannerSensor.get();
    }

    public void periodic() {

    }
 
}
