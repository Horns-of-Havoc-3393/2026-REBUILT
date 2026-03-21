package frc.robot;

import frc.robot.commands.ShootnFeedCommand;
import frc.robot.commands.intakeCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShootSubsystem;
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
    public ShootSubsystem shooter = new ShootSubsystem();

    public RobotContainer() {
        NamedCommands.registerCommand("Shooter command", new ShootCommand(shooter,1));
        configureBindings();
        drivebase.setDefaultCommand(driveFieldOrientedAngularVelocity);
        shooter.setDefaultCommand(new ShootnFeedCommand(shooter,driver.getRightTriggerAxis(),driver.getLeftTriggerAxis()));
        
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
        driver.leftBumper().toggleOnTrue(new intakeCommand(intake));
        
    }
    public Command getAutonomousCommand() {
    
    return drivebase.getAutonomousCommand(path);    
    //return drivebase.getAutonomousCommand("Blue Playoffs Bonney Lake");    
    }
    public void SetPath(String pth){
        path = pth;
    }

}
