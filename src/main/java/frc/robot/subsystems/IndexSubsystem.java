package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class IndexSubsystem {
    private static Spark Index = new Spark(Constants.ID_INDEX_MOTOR);
    private static Spark Feed = new Spark(Constants.ID_FEED_MOTOR);

    public static void setIndexSpeed(double speed){
        Index.set(speed);
    }
    
    public static void setFeedSpeed(double speed){
        Feed.set(speed);
    }

    public static void ShootFullSpeed() {
        setFeedSpeed(Constants.FULL_SPEED_FEED);
        setIndexSpeed(Constants.FULL_SPEED_INDEX);
    }

    public void periodic() {

    }
 
}
