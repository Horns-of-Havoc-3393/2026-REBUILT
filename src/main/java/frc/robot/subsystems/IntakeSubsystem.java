package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem  extends SubsystemBase{
    public SparkMax bottomRoller = new SparkMax(Constants.IntakeSparkIDB, MotorType.kBrushless);
    public SparkMax topRoller = new SparkMax(Constants.IntakeSparkIDT, MotorType.kBrushless);
    public SparkMax lift = new SparkMax(Constants.IntakeFlipSparkID, MotorType.kBrushless);
    public IntakeSubsystem(){        
    }
    
    public void Flip(double rate){
        System.out.println("flipper: "+lift.getOutputCurrent());
        lift.set(rate);
    }
    public void Roll(double speed){
        topRoller.set(speed);
        bottomRoller.set(speed);
    }
    @Override
    public void periodic(){
        SmartDashboard.putNumber("liftCUrrent", lift.getOutputCurrent());
    }

}
