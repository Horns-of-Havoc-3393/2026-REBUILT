package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.FeedSubsystem;

public class feedJoyCommand extends Command {
    FeedSubsystem subby;
    DoubleSupplier speed;
    public feedJoyCommand(FeedSubsystem subby, DoubleSupplier speed){
        this.subby = subby;
        this.speed = speed;
       addRequirements(subby);
    }
    @Override
    public void initialize(){}
    @Override
    public void execute(){
        subby.Feed(speed.getAsDouble());
    }
    @Override
    public void end(boolean interrupted){
    }
    @Override
    public boolean isFinished(){
        return false;
    }
}