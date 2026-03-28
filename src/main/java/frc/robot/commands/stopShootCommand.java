package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShootSubsystem;

public class stopShootCommand extends Command {
    ShootSubsystem subby;
    public stopShootCommand(ShootSubsystem subby){
        this.subby = subby;
        addRequirements(subby);
    }
    @Override
    public void initialize(){}
    @Override
    public void execute(){
        subby.PowerMotor(0);
    }
    @Override
    public void end(boolean interrupted){
        //subby.PowerMotor(0);
    }
    @Override
    public boolean isFinished(){
        return subby.getMotorSpeed()<50;
    }
}