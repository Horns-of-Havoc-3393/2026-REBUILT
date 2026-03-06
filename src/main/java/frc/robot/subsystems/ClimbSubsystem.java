package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimbSubsystem extends SubsystemBase{
    DigitalInput topLimit = new DigitalInput(0);
    DigitalInput bottomLimit = new DigitalInput(0);
    TalonFX KrakenLeft = new TalonFX(Constants.KrakenLiftIDL);
    TalonFX KrakenRight = new TalonFX(Constants.KrakenLiftIDR);
    
    public ClimbSubsystem(){
        KrakenLeft.setNeutralMode(NeutralModeValue.Brake);
        KrakenRight.setNeutralMode(NeutralModeValue.Brake);
        

    }
    public void Zero(){
        
    }
    public void Set(){
    }
    // public void Extend(double rate){
    //     if(topLimit.get()){
    //         KrakenLeft.set(0);
    //         KrakenRight.set(0);
    //         rate = 0;
    //     }else{
    //         KrakenLeft.set(rate);
    //         KrakenRight.set(rate);
    //     }
    // }
    // public void Retract(double rate){
    //     if(bottomLimit.get()){
    //         KrakenRight.set(0);
    //         KrakenLeft.set(0);
    //         rate = 0;
    //     }else{
    //         KrakenRight.set(rate);
    //         KrakenLeft.set(rate);
    //     }
    
    // }

}
