package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class HopperSubsystem  extends SubsystemBase{
    double calcSpeed;
    boolean upTrig = false;
    boolean downTrig = false;
    boolean limit = false;
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
            limit = true;
            lift.set(0);
        }else{
            lift.set(calcSpeed);
     }

    }
    public void safeLift(boolean up, boolean down){
        if(up&&downTrig){
            if(lift.getOutputCurrent()>Constants.LiftCurrentStop){
                upTrig = true;
                downTrig=false;
                lift.set(0);
            }else{
                lift.set(.3);
            }
        }else if(upTrig && down){
            if(lift.getOutputCurrent()>Constants.LiftCurrentStop){
                downTrig = true;
                upTrig = false;
                lift.set(0);
            }else{
                lift.set(-.3);
            }
        }
    }
    
    //negative down/out
    @Override
    public void periodic(){
        SmartDashboard.putNumber("Lift Current", lift.getOutputCurrent());
        SmartDashboard.putNumber("speedGivenlift", calcSpeed);
    }

}
