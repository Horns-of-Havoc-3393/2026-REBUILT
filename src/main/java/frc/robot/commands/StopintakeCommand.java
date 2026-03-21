package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class StopintakeCommand extends Command {

    IntakeSubsystem subby;
    public StopintakeCommand(IntakeSubsystem subby){
        this.subby = subby;
        //addRequirements(subby);
    }


    @Override
    public void initialize(){}
    @Override
    public void execute(){
        subby.Roll(0);
        end(isScheduled());
    }
    @Override
    public void end(boolean interrupted){
    }
    @Override
    public boolean isFinished(){
        return false;
    }
}