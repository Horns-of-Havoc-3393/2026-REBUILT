package frc.robot.commands;

import java.util.function.DoubleSupplier;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShootSubsystem;

public class shootJoyCommand extends Command {
    ShootSubsystem subby;
    DoubleSupplier speedF;
    DoubleSupplier speedR; 
    public shootJoyCommand(ShootSubsystem subby, DoubleSupplier speedF/* , DoubleSupplier speedR*/){
        this.subby = subby;
        this.speedF = speedF;
        //this.speedR = speedR;
        addRequirements(subby);
    }
    @Override
    public void initialize(){}
    @Override
    public void execute(){
        subby.PowerMotor(/*((speedR.getAsDouble()+1)/2)*/((speedF.getAsDouble())));
    }
    @Override
    public void end(boolean interrupted){
        subby.PowerMotor(0);
    }
    @Override
    public boolean isFinished(){
        return false;
    }
}