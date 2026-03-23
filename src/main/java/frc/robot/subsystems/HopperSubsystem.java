package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class HopperSubsystem  extends SubsystemBase{
    public SparkMax lift = new SparkMax(Constants.IntakeFlipSparkID, MotorType.kBrushless);
    public HopperSubsystem(){        
    }
    public void Lift(double speed){
        lift.set(speed);
    }
    //negative down/out
    @Override
    public void periodic(){
        SmartDashboard.putNumber("Lift Current", lift.getOutputCurrent());
    }

}
