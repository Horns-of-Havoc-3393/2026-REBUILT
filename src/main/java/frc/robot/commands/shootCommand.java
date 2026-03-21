package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShootSubsystem;

public class shootCommand extends Command {
    ShootSubsystem subby;
    double speed;
    public shootCommand(ShootSubsystem subby, double speed){
        this.subby = subby;
        this.speed = speed;
        //addRequirements(subby);
    }
    @Override
    public void initialize(){}
    @Override
    public void execute(){
        
        subby.RampUP(speed);
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