package frc.robot.commands;

import java.util.function.DoubleSupplier;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShootSubsystem;

public class shootJoyCommand extends Command {
    ShootSubsystem subby;
    DoubleSupplier speed;
    public shootJoyCommand(ShootSubsystem subby, DoubleSupplier speed){
        this.subby = subby;
        this.speed = speed;
        addRequirements(subby);
    }
    @Override
    public void initialize(){}
    @Override
    public void execute(){
        subby.RampUP(speed.getAsDouble());
    }
    @Override
    public void end(boolean interrupted){
    }
    @Override
    public boolean isFinished(){
        return false;
    }
}