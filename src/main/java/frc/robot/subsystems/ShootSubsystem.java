package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShootSubsystem extends SubsystemBase{
    SparkFlex shooter = new SparkFlex(Constants.ShooterVortexID, MotorType.kBrushless);
     double p =0.00028;
     double i =0;
     double d =0;
    PIDController pid = new PIDController(p,i,d);
    double Rpm;
    public ShootSubsystem(){
        // SmartDashboard.putNumber("P", pid.getP());
        // SmartDashboard.putNumber("I", pid.getI());
        // SmartDashboard.putNumber("D", pid.getD());
    }
    public void RampUP(double rpm){
        Rpm = rpm;
        if(rpm<20&&rpm>-20){rpm = 0;}

        if(rpm!=0){
            if(rpm>0 || rpm<0){
                shooter.set(pid.calculate(shooter.getEncoder().getVelocity(), rpm));
            }else if(rpm<0){
                shooter.set(pid.calculate(shooter.getEncoder().getVelocity(), rpm));
            }
        }else{
            shooter.set(0);
        }
       //80% shooter speed, 2 ball goal from tower
        //shooter.set((.7)*rpm);
    }
    public void PowerMotor(double Speed){
        if(Speed>-.1&&Speed<.1){Speed=0;}
        shooter.set(Speed);
    }
    public void addP(){
        p=p+0.00001;
    }
    public void minusP(){
        p=p+0.00001;
    }
    public void addI(){
        i=i+0.0000001;
    }
    public void minusI(){
        i=i+0.0000001;
    }
    public void addD(){
        d=d+0.0000001;
    }
    public void minusD(){
        d=d+0.0000001;
    }
    public void setPID(){
        pid.setPID(p, i, d);
    }
    public double getMotorSpeed(){
        return shooter.getEncoder().getVelocity();
    }
    @Override
    public void periodic(){
        SmartDashboard.putNumber("Shooter RPM", shooter.getEncoder().getVelocity());
        SmartDashboard.putNumber("target RPM", Rpm);    
        SmartDashboard.putNumber("P", p);
        SmartDashboard.putNumber("I",i);
        SmartDashboard.putNumber("D", d);
        setPID();
    }
}
