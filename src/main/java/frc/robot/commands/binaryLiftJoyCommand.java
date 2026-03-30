package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.HopperSubsystem;

public class binaryLiftJoyCommand extends Command {

    HopperSubsystem subby;
    public binaryLiftJoyCommand(HopperSubsystem subby){
        this.subby = subby;
        addRequirements(subby);
    }


    @Override
    public void initialize(){}
    @Override
    public void execute(){
        subby.AutoLiftDown(-0.5);        
    }
    @Override
    public void end(boolean interrupted){
        subby.AutoLiftUp(0.5);
    }
   
    @Override
    public boolean isFinished(){
        return false;
    }
}