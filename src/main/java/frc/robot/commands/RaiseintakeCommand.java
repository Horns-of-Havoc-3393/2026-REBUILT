package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.HopperSubsystem;

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
        subby.Lift(.3);
    }
    @Override
    public void end(boolean interrupted){
        subby.Lift(0);
    }
    @Override
    public boolean isFinished(){
        return subby.lift.getOutputCurrent()<Constants.LiftCurrentStop;
    }
}