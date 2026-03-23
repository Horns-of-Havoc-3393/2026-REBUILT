package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShootSubsystem extends SubsystemBase{
    SparkFlex shooter = new SparkFlex(Constants.ShooterVortexID, MotorType.kBrushless);
    PIDController pid = new PIDController(.00005, 0.000000, 0.0);
    double Rpm;
    public ShootSubsystem(){
        
    }
    public void RampUP(double rpm){
        Rpm = rpm;
        if(rpm<20&&rpm>-20){rpm = 0;}

        if(rpm!=0){
            shooter.set(pid.calculate(shooter.getEncoder().getVelocity(), rpm));
        }else{
            shooter.set(0);
        }
       //80% shooter speed, 2 ball goal from tower
        //shooter.set((.7)*rpm);
    }
    public void PowerMotor(double Speed){
        shooter.set(Speed);
    }
    @Override
    public void periodic(){
        SmartDashboard.putNumber("Shooter RPM", shooter.getEncoder().getVelocity());
        SmartDashboard.putNumber("target RPM", Rpm);
    }
}
