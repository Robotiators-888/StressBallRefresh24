package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class IndexSubsystem {
    private Spark Index = new Spark(Constants.ID_INDEX_MOTOR);
    private Spark Feed = new Spark(Constants.ID_FEED_MOTOR);

    public void setIndexSpeed(double speed){
        Index.set(speed);
    }
    
    public void setFeedSpeed(double speed){
        Feed.set(speed);
    }
    public void periodic() {

    }
 
}
