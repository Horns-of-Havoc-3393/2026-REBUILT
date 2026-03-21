package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShootSubsystem extends SubsystemBase{
    SparkMax feeder = new SparkMax(Constants.ShooterRollerSparkID, MotorType.kBrushless);
    SparkFlex shooter = new SparkFlex(Constants.ShooterVortexID, MotorType.kBrushless);
    SlewRateLimiter limit = new SlewRateLimiter(10);
    public ShootSubsystem(){
        
    }
    public void RampUP(double percentage){
        shooter.set(limit.calculate(percentage));
    }
    public void Feed(double rate){
            feeder.set(rate);
    }
}
