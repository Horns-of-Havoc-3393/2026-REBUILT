package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.filter.SlewRateLimiter;
import frc.robot.Constants;

public class ShooterSubsystem {
    SparkMax feeder = new SparkMax(Constants.ShooterRollerSparkID, MotorType.kBrushless);
    SparkFlex shooter = new SparkFlex(Constants.ShooterVortexID, MotorType.kBrushless);
    SlewRateLimiter limit = new SlewRateLimiter(.3);
    public ShooterSubsystem(){
        
    }
    public void RampUP(double percentage){
        shooter.set(limit.calculate(percentage));
    }
    
}
