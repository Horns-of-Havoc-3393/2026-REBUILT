package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class intakeCommand extends Command {

    IntakeSubsystem subby;
    public intakeCommand(IntakeSubsystem subby){
        this.subby = subby;
        //addRequirements(subby);
    }


    @Override
    public void initialize(){}
    @Override
    public void execute(){
        subby.Roll(1);
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