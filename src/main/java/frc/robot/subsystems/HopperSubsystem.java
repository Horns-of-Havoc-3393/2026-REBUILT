package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class HopperSubsystem  extends SubsystemBase{
    double calcSpeed;
    double autoSpeedCalced;
    boolean upTrig = false;
    boolean downTrig = false;
    boolean limit = false;
    boolean upLimit = false;
    boolean downLimit = false;
    public SparkMax lift = new SparkMax(Constants.IntakeFlipSparkID, MotorType.kBrushless);
    public HopperSubsystem(){        
    }
    public void Lift(double speed){
    if(lift.getOutputCurrent()<Constants.LiftCurrentStop){
        lift.set(speed);
    }else{lift.set(0);}
    }
    public void ManualLift(double speedUP, double speedDown, boolean reset){

        if(lift.getOutputCurrent()<Constants.LiftCurrentStop && !limit){
            calcSpeed=speedUP+speedDown;
        }else{
            limit = true;
        }
        if(reset){
            limit=false;
        }
        if(limit){
            calcSpeed = 0;
            //limit = true;
            lift.set(0);
        }else{
            lift.set(calcSpeed);
     }

    }
    public void AutoLiftUp(double speed){
        if(lift.getOutputCurrent()>Constants.LiftCurrentStop && !upLimit){
            autoSpeedCalced = speed;
        }else{
            upLimit = true;
            downLimit = false;
        }
        if(upLimit){
            lift.set(0);
        }else{
            lift.set(autoSpeedCalced);
        }
    }
    public void AutoLiftDown(double speed){
        if(lift.getOutputCurrent()>Constants.LiftCurrentStop && !downLimit){
            autoSpeedCalced = speed;
        }else{
            downLimit = true;
            upLimit = false;
        }
        if(downLimit){
            lift.set(0);
        }else{
            lift.set(autoSpeedCalced);
        }
    }
    public void limitReset(){
        upLimit = false;
        downLimit = false;
    }
    public boolean isDownStopped(){
        return downLimit;
    }
    public boolean isUpStopped(){
        return upLimit;
    }
    public void powerLift(double speed){
        lift.set(speed);
    }
    //negative down/out


}
