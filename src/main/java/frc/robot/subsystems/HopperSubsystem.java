package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class HopperSubsystem  extends SubsystemBase{
    public SparkMax bottomRoller = new SparkMax(Constants.IntakeSparkIDB, MotorType.kBrushless);
    public SparkMax topRoller = new SparkMax(Constants.IntakeSparkIDT, MotorType.kBrushless);
    public SparkMax lift = new SparkMax(Constants.IntakeFlipSparkID, MotorType.kBrushless);
    public HopperSubsystem(){        
    }
    public void Lift(double speed){
        lift.set(speed);
    }
    @Override
    public void periodic(){
        
    }

}
