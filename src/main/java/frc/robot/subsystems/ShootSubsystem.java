package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShootSubsystem extends SubsystemBase{
    SparkFlex shooter = new SparkFlex(Constants.ShooterVortexID, MotorType.kBrushless);
    PIDController pid = new PIDController(0, 0, 0);
    public ShootSubsystem(){
        
    }
    public void RampUP(double rpm){
        pid.calculate(shooter.getEncoder().getVelocity(), rpm);
    }
}
