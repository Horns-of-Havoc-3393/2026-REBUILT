package frc.robot.subsystems;

import org.opencv.dnn.Net;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.TableListener;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem  extends SubsystemBase{
    //SparkMax rightRoller = new SparkMax(Constants.IntakeSparkIDR, MotorType.kBrushless);
    public SparkMax leftRoller = new SparkMax(Constants.IntakeSparkIDL, MotorType.kBrushless);
    public SparkMax lift = new SparkMax(Constants.IntakeFlipSparkID, MotorType.kBrushless);
    //NetworkTableInstance tableInstance = NetworkTableInstance.getDefault();
    public IntakeSubsystem(){
        //tableInstance.getTable("INtake").getDoubleTopic("flipper").publish().set(lift.getOutputCurrent());
        
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
    public Command MoveDown(){return runOnce(()->{
        move(-.5);
    });}
    public Command spinDown(){
        return runOnce(() -> {
            leftRoller.set(0);
        });
    }
    public Command spinUp(){return runOnce(()->{
        leftRoller.set(-1);
    });}
        public Command spinOut(){return runOnce(()->{
        leftRoller.set(1);
    });}

}
