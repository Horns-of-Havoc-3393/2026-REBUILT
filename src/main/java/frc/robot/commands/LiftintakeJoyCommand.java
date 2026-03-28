package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.HopperSubsystem;

public class LiftintakeJoyCommand extends Command {

    HopperSubsystem subby;
    DoubleSupplier speedUp;
    DoubleSupplier speedDown;
    BooleanSupplier reset;
    public LiftintakeJoyCommand(HopperSubsystem subby, DoubleSupplier speedUp, DoubleSupplier speedDown,BooleanSupplier reset){
        this.subby = subby;
        this.speedUp = speedUp;
        this.speedDown = speedDown;
        this.reset = reset;
        addRequirements(subby);
    }


    @Override
    public void initialize(){}
    @Override
    public void execute(){
     subby.ManualLift(((speedUp.getAsDouble()+1)/2)/4,-((speedDown.getAsDouble()+1)/2)/4, reset.getAsBoolean());     
        
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