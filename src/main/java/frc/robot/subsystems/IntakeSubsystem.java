package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem  extends SubsystemBase{
    public SparkMax leftRoller = new SparkMax(Constants.IntakeSparkIDL, MotorType.kBrushless);
    public SparkMax lift = new SparkMax(Constants.IntakeFlipSparkID, MotorType.kBrushless);
    public IntakeSubsystem(){        
    }
    
    public void move(double rate){
        System.out.println("flipper: "+lift.getOutputCurrent());
        lift.set(rate);
    }

}
