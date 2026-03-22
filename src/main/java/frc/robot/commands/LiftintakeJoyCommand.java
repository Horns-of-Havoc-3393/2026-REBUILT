package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.HopperSubsystem;

public class LiftintakeJoyCommand extends Command {

    HopperSubsystem subby;
    public LiftintakeJoyCommand(HopperSubsystem subby){
        this.subby = subby;
        addRequirements(subby);
    }


    @Override
    public void initialize(){}
    @Override
    public void execute(){
        if(subby.lift.getOutputCurrent()<Constants.LiftCurrentStop){
            subby.Lift(-.3);
        }else{
            subby.Lift(0);
        }
    }
    @Override
    public void end(boolean interrupted){
        if(subby.lift.getOutputCurrent()<Constants.LiftCurrentStop){
            subby.Lift(.3);
        }else{
            subby.Lift(0);
        } 
    }
    @Override
    public boolean isFinished(){
        return false;
    }
}