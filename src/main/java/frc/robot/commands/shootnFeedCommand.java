package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShootSubsystem;

public class shootnFeedCommand extends Command {
    ShootSubsystem subby;
    double speed;
    double rate;
    public shootnFeedCommand(ShootSubsystem subby, double speed,double rate){
        this.subby = subby;
        this.speed = speed;
        this.rate = rate;
        addRequirements(subby);
    }
    @Override
    public void initialize(){}
    @Override
    public void execute(){
        
        subby.RampUP(speed);
        subby.Feed(rate);
    }
    @Override
    public void end(boolean interrupted){
        subby.RampUP(0);
    }
    @Override
    public boolean isFinished(){
        return false;
    }
}