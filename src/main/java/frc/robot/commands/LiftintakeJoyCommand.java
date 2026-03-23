package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.HopperSubsystem;

public class LiftintakeJoyCommand extends Command {

    HopperSubsystem subby;
    DoubleSupplier speedUp;
    DoubleSupplier speedDown;
    public LiftintakeJoyCommand(HopperSubsystem subby, DoubleSupplier speedUp, DoubleSupplier speedDown){
        this.subby = subby;
        this.speedUp = speedUp;
        this.speedDown = speedDown;
        addRequirements(subby);
    }


    @Override
    public void initialize(){}
    @Override
    public void execute(){
        if(subby.lift.getOutputCurrent()<Constants.LiftCurrentStop){
            subby.Lift(speedUp.getAsDouble()/4-speedDown.getAsDouble()/4);
        }else{
            subby.Lift(0);
        }
        
    }
    @Override
    public void end(boolean interrupted){
        // if(subby.lift.getOutputCurrent()<Constants.LiftCurrentStop){
        //     subby.Lift(.3);
        // }else{
        //     subby.Lift(0);
        // } 
    }
   
    @Override
    public boolean isFinished(){
        return false;
    }
}