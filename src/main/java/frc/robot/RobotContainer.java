package frc.robot;

import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.SwerveSubsystem;
import swervelib.SwerveInputStream; 
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {     
    String path = ""; 

    private final CommandXboxController driver = new CommandXboxController(Constants.OperatorConstants.kDriverControllerPort);
    public SwerveSubsystem drivebase = new SwerveSubsystem();
    public IntakeSubsystem intake = new IntakeSubsystem();

    public RobotContainer() {
        configureBindings();
        drivebase.setDefaultCommand(driveFieldOrientedAngularVelocity);
        

    }
    
    SwerveInputStream driveAngularVelo = SwerveInputStream.of(drivebase.getSwerveDrive(),
                                                              ()-> driver.getLeftY()*-1,
                                                              ()-> driver.getLeftX()*-1)
                                                              .withControllerRotationAxis(() -> -driver.getRightX())
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
        intake.Move(driver.getRightTriggerAxis()- driver.getLeftTriggerAxis());
        driver.rightBumper().toggleOnFalse(intake.spinDown());
        driver.rightBumper().toggleOnTrue(intake.spinUp());  
    }
    public Command getAutonomousCommand() {
    
    //return drivebase.getAutonomousCommand(path);    
    return drivebase.getAutonomousCommand(path);    
    }
    public void SetPath(String pth){
        path = pth;
    }

}
