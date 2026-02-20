package frc.robot;

import frc.robot.subsystems.SwerveSubsystem;
import swervelib.SwerveInputStream;

import java.util.Optional;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {     
    String path = ""; 
    Optional<Alliance> ally = DriverStation.getAlliance();

    private final CommandXboxController driver = new CommandXboxController(Constants.OperatorConstants.kDriverControllerPort);
    public SwerveSubsystem drivebase = new SwerveSubsystem();

    public RobotContainer() {
        configureBindings();
    drivebase.setDefaultCommand(driveFieldOrientedAngularVelocity);
    }
    SwerveInputStream driveAngularVelo = SwerveInputStream.of(drivebase.getSwerveDrive(),
                                                              ()-> driver.getLeftY()*-1,
                                                              ()-> driver.getLeftX()*-1)
                                                              .withControllerRotationAxis(driver::getRightX)
                                                              .deadband(Constants.stickDeadband)
                                                              .scaleTranslation(1.5)
                                                              .allianceRelativeControl(true);
                                                               
    SwerveInputStream driveHeading = driveAngularVelo.copy().withControllerHeadingAxis(driver::getRightX,
                                                                                       driver::getRightY)
                                                                                       .headingWhile(true);


    Command driveFieldOrientedDirectAngle = drivebase.driveFieldOriented(driveHeading);
    Command driveFieldOrientedAngularVelocity = drivebase.driveFieldOriented(driveAngularVelo);
    
    private void configureBindings() {
        driver.start().onTrue(new InstantCommand(()->{drivebase.YawReset();},drivebase));
    }
    public Command getAutonomousCommand() {
    if (ally.isPresent()) {
        if (ally.get() == Alliance.Red) {
            switch (DriverStation.getLocation().toString()) {
                case "1" -> path = "Red1";
                case "2" -> path = "Red2";
                case "3" -> path = "Red3";
            }
        }
        if (ally.get() == Alliance.Blue) {
               switch (DriverStation.getLocation().toString()) {
                case "1" -> path = "Blue1";
                case "2" -> path = "Blue2";
                case "3" -> path = "Blue3";
            }
        }
        }
    else {
        System.err.print("no alliance");
    }
    return drivebase.getAutonomousCommand(path);       
    }
}
