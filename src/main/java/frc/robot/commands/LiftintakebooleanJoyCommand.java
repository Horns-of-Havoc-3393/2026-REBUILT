package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.HopperSubsystem;

public class LiftintakebooleanJoyCommand extends Command {

    HopperSubsystem subby;
    BooleanSupplier Up;
    BooleanSupplier Down;
    public LiftintakebooleanJoyCommand(HopperSubsystem subby, BooleanSupplier Up, BooleanSupplier Down){
        this.subby = subby;
        this.Up = Up;
        this.Down = Down;
        addRequirements(subby);
    }


    @Override
    public void initialize(){}
    @Override
    public void execute(){
     subby.safeLift(Up.getAsBoolean(), Down.getAsBoolean());    
        
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