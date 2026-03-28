package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShootSubsystem;

public class binaryshootCommand extends Command {
    ShootSubsystem subby;
    double speed;
    public binaryshootCommand(ShootSubsystem subby, double speed){
        this.subby = subby;
        this.speed = speed;
        addRequirements(subby);
    }
    @Override
    public void initialize(){}
    @Override
    public void execute(){
        subby.PowerMotor(speed);
    }
    @Override
    public void end(boolean interrupted){
        subby.PowerMotor(0);
    }
    @Override
    public boolean isFinished(){
        //return ( ((speed*3000)-200)<Math.abs(subby.getMotorSpeed()) && (Math.abs(subby.getMotorSpeed())<(speed*3000)+200));
        return false;
    }
}