package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;

public class LiftintakeCommand extends Command {

    IntakeSubsystem subby;
    public LiftintakeCommand(IntakeSubsystem subby){
        this.subby = subby;
        //addRequirements(subby);
    }


    @Override
    public void initialize(){}
    @Override
    public void execute(){
        if(subby.lift.getOutputCurrent()<Constants.LiftCurrentStop){
            subby.Flip(-.3);
        }else{
            subby.Flip(0);
        }
    }
    @Override
    public void end(boolean interrupted){
        if(subby.lift.getOutputCurrent()<Constants.LiftCurrentStop){
            subby.Flip(.3);
        }else{
            subby.Flip(0);
        } 
    }
    @Override
    public boolean isFinished(){
        return false;
    }
}