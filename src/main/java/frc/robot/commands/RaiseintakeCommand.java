package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.HopperSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class RaiseintakeCommand extends Command {

    HopperSubsystem subby;
    public RaiseintakeCommand(HopperSubsystem subby){
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
            end(isScheduled());
        }
    }
    @Override
    public void end(boolean interrupted){
    }
    @Override
    public boolean isFinished(){
        return false;
    }
}