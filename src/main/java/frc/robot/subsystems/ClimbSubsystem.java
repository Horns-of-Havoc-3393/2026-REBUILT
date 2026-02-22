package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import frc.robot.Constants;

public class ClimbSubsystem {
    TalonFX KrakenLeft = new TalonFX(Constants.KrakenLiftIDL);
    TalonFX KrakenRight = new TalonFX(Constants.KrakenLiftIDR);

}
