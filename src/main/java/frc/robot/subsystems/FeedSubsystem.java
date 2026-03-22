package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FeedSubsystem extends SubsystemBase{
    SparkMax feeder = new SparkMax(Constants.ShooterVortexID, MotorType.kBrushless);
    public FeedSubsystem(){
        
    }
    public void Feed(double percentage){
        feeder.set((percentage));
    }
}
