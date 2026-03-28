package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class intakeJoyCommand extends Command {

    IntakeSubsystem subby;
    public intakeJoyCommand(IntakeSubsystem subby){
        this.subby = subby;
        addRequirements(subby);
    }


    @Override
    public void initialize(){}
    @Override
    public void execute(){
        subby.Roll(1);
    }
    @Override
    public void end(boolean interrupted){
        subby.Roll(0);
    }
    @Override
    public boolean isFinished(){
        return false;
    }
}