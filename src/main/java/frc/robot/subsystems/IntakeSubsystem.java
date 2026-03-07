package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem  extends SubsystemBase{
    SparkMax rightRoller = new SparkMax(Constants.IntakeSparkIDR, MotorType.kBrushless);
    SparkMax leftRoller = new SparkMax(Constants.IntakeSparkIDL, MotorType.kBrushless);
    SparkMax lift = new SparkMax(Constants.IntakeFlipSparkID, MotorType.kBrushless);

    public IntakeSubsystem(){
        
    }
    public void move(double rate){
        System.out.println("flipper: "+lift.getOutputCurrent());
        lift.set(rate);
    }
    public Command Move(double rate){
        return runOnce(
            () ->{
                move(rate);
        });
    }
    public Command spinDown(){
        return runOnce(() -> {
            leftRoller.set(0);
        });
    }
    public Command spinUp(){return runOnce(()->{
        leftRoller.set(-1);
    });}
}
