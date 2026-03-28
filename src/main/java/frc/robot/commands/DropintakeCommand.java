package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.HopperSubsystem;

public class DropintakeCommand extends Command {

    HopperSubsystem subby;
    public DropintakeCommand(HopperSubsystem subby){
        this.subby = subby;
        addRequirements(subby);
    }


    @Override
    public void initialize(){}
    @Override
    public void execute(){
        subby.AutoLiftDown(.3);
    }
    @Override
    public void end(boolean interrupted){
        
    }
    @Override
    public boolean isFinished(){
        return subby.isDownStopped();
         
    }
}