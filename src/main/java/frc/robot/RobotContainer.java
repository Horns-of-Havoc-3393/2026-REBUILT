package frc.robot;

import frc.robot.commands.shootnFeedCommand;
import frc.robot.commands.shootCommand;
import frc.robot.commands.feedCommand;
import frc.robot.commands.DropintakeCommand;
import frc.robot.commands.RaiseintakeCommand;
import frc.robot.commands.StopintakeCommand;
import frc.robot.commands.intakeCommand;

import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShootSubsystem;
import frc.robot.subsystems.SwerveSubsystem;
import swervelib.SwerveInputStream;

import com.pathplanner.lib.auto.NamedCommands;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {     
    String path = ""; 

    private final CommandXboxController driver = new CommandXboxController(Constants.OperatorConstants.kDriverControllerPort);
    private final CommandXboxController operatror = new CommandXboxController(Constants.OperatorConstants.kOperatorControllerPort);
    
    public SwerveSubsystem drivebase = new SwerveSubsystem();
    public IntakeSubsystem intake = new IntakeSubsystem();
    public ShootSubsystem shooter = new ShootSubsystem();
    
    public RobotContainer() {
        configureBindings();
        drivebase.setDefaultCommand(!RobotBase.isSimulation() ? driveFieldOrientedAngularVelocity:driveFieldOrientedDirectAngle);
        NamedCommands.registerCommand("test", Commands.print("hellow world"));
        NamedCommands.registerCommand("Shooter command", new shootCommand(shooter,1));
        NamedCommands.registerCommand("droxpIntake command", new DropintakeCommand(intake));
        NamedCommands.registerCommand("raiseIntake command", new RaiseintakeCommand(intake));
        NamedCommands.registerCommand("spinIntake command", new intakeCommand(intake));
        NamedCommands.registerCommand("StopIntake command", new StopintakeCommand(intake));
        NamedCommands.registerCommand("StopShooter command", new shootCommand(shooter,-1));
        NamedCommands.registerCommand("Feed command", new feedCommand(shooter,.3));
        NamedCommands.registerCommand("stopFeed command", new feedCommand(shooter,0));
        shooter.setDefaultCommand(new shootnFeedCommand(shooter,operatror.getRightTriggerAxis(),operatror.getLeftTriggerAxis()));
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
        operatror.leftBumper().toggleOnTrue(new intakeCommand(intake));

        
    }
    public Command getAutonomousCommand() {
    
    return drivebase.getAutonomousCommand(path);    
    //return drivebase.getAutonomousCommand("Blue Playoffs Bonney Lake");    
    }
    public void SetPath(String pth){
        path = pth;
    }

}
