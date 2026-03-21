package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;

public class RaiseintakeCommand extends Command {

    IntakeSubsystem subby;
    public RaiseintakeCommand(IntakeSubsystem subby){
        this.subby = subby;
        addRequirements(subby);
    }


    @Override
    public void initialize(){}
    @Override
    public void execute(){
        if(subby.lift.getOutputCurrent()<Constants.LiftCurrentStop){
            subby.Flip(-.3);
        }else{
            subby.Flip(0);
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