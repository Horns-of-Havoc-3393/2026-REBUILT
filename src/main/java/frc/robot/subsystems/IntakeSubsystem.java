package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import frc.robot.Constants;

public class IntakeSubsystem {
    SparkMax rightRoller = new SparkMax(Constants.IntakeSparkIDR, MotorType.kBrushless);
    SparkMax leftRoller = new SparkMax(Constants.IntakeSparkIDL, MotorType.kBrushless);
    SparkMax lift = new SparkMax(Constants.IntakeFlipSparkID, MotorType.kBrushless);

    public IntakeSubsystem(){
        
    }
}
