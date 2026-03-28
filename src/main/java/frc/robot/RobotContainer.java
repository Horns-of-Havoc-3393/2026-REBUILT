package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.FeedSubsystem;
import frc.robot.subsystems.HopperSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShootSubsystem;
import frc.robot.subsystems.SwerveSubsystem;
import swervelib.SwerveInputStream;

import com.pathplanner.lib.auto.NamedCommands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandGenericHID;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {     
    String path = ""; 

    private final CommandXboxController driver = new CommandXboxController(Constants.OperatorConstants.kDriverControllerPort);
    private final CommandXboxController operatror = new CommandXboxController(Constants.OperatorConstants.kOperatorControllerPort);
    private final CommandGenericHID pad = new CommandGenericHID(Constants.OperatorConstants.kHIDOperatorControllerPort);

    public SwerveSubsystem drivebase = new SwerveSubsystem();
    public IntakeSubsystem intake = new IntakeSubsystem();
    public ShootSubsystem shooter = new ShootSubsystem();
    public HopperSubsystem hopper = new HopperSubsystem();
    public FeedSubsystem feeder = new FeedSubsystem();
    public RobotContainer() {
        configureBindings();
        drivebase.setDefaultCommand(!RobotBase.isSimulation() ? driveFieldOrientedAngularVelocity:driveFieldOrientedDirectAngle);
        NamedCommands.registerCommand("test", Commands.print("hellow world"));
        NamedCommands.registerCommand("Shooter command", new shootCommand(shooter,1));
        NamedCommands.registerCommand("droxpIntake command", new DropintakeCommand(hopper));
        NamedCommands.registerCommand("raiseIntake command", new RaiseintakeCommand(hopper));
        NamedCommands.registerCommand("spinIntake command", new intakeCommand(intake));
        NamedCommands.registerCommand("StopIntake command", new StopintakeCommand(intake));
        NamedCommands.registerCommand("StopShooter command", new shootCommand(shooter,-1));
        NamedCommands.registerCommand("Feed command", new feedCommand(feeder,.3));
        NamedCommands.registerCommand("stopFeed command", new feedCommand(feeder,0));
        //shooter.setDefaultCommand(new shootJoyCommand(shooter,driver::getLeftTriggerAxis));
        //feeder.setDefaultCommand(new feedJoyCommand(feeder, driver::getRightTriggerAxis));
        
    }   
    
    SwerveInputStream driveAngularVelo = SwerveInputStream.of(drivebase.getSwerveDrive(),
    ()-> driver.getLeftY()*-1,
    ()-> driver.getLeftX()*-1)
    .withControllerRotationAxis(() -> -driver.getRightX())
    .deadband(Constants.stickDeadband)
    .scaleTranslation(1)
    .allianceRelativeControl(true);
    
    SwerveInputStream driveHeading = driveAngularVelo.copy().withControllerHeadingAxis(driver::getRightX,
    driver::getRightY)
    .headingWhile(true);
    
    
    Command driveFieldOrientedDirectAngle = drivebase.driveFieldOriented(driveHeading);
    Command driveFieldOrientedAngularVelocity = drivebase.driveFieldOriented(driveAngularVelo);
    
    
    private void configureBindings() {
        driver.start().onTrue(new InstantCommand(()->{drivebase.YawReset();},drivebase));
        
        //driver.rightBumper().toggleOnTrue(new shootPIDCommand(shooter, -7000));
        //driver.rightBumper().toggleOnTrue(new shootCommand(shooter, -1));
        //driver.leftBumper().whileTrue(new feedCommand(feeder, .5));
        //driver.a().toggleOnTrue(new intakeJoyCommand(intake));
        if(pad.isConnected()){
            //shooter.setDefaultCommand(new shootJoyCommand(shooter, ()-> pad.getRawAxis(0),()->pad.getRawAxis(2)));
            hopper.setDefaultCommand(new LiftintakeJoyCommand(hopper, ()->pad.getRawAxis(3),()->pad.getRawAxis(1), pad.button(4)));
        
            //hopper.setDefaultCommand(new LiftintakebooleanJoyCommand(hopper, pad.button(1),pad.button(9)));
            pad.button(1).onTrue(Commands.print("1"));
            pad.button(1).onTrue(new InstantCommand(()->{shooter.addP();}));
            pad.button(2).onTrue(Commands.print("2"));
            pad.button(2).onTrue(new InstantCommand(()->{shooter.addI();}));
            pad.button(12).onTrue(Commands.print("12"));
            pad.button(4).onTrue(Commands.print("4"));
            pad.button(5).onTrue(Commands.print("5"));
            pad.button(5).toggleOnTrue(new shootPIDCommand(shooter, ((pad.getRawAxis(0)+1)/2)*6000));
            pad.button(6).onTrue(Commands.print("6"));
            pad.button(6).onTrue(new InstantCommand(()->{shooter.minusD();}));
            pad.button(7).onTrue(Commands.print("7"));
            pad.button(8).onTrue(Commands.print("8"));
            //pad.button(8).onTrue(new InstantCommand(()->{shooter.setPID();}));
            pad.button(9).onTrue(Commands.print("9"));
            pad.button(9).onTrue(new InstantCommand(()->{shooter.minusP();}));
            pad.button(10).onTrue(Commands.print("10"));
            pad.button(10).onTrue(new InstantCommand(()->{shooter.minusI();}));
            pad.button(11).onTrue(Commands.print("11"));
            pad.button(11).onTrue(new InstantCommand(()->{shooter.addD();}));
            System.out.println("axis 1" + pad.getRawAxis(0));
            System.out.println("axis 2" + pad.getRawAxis(1));
            System.out.println("axis 3" + pad.getRawAxis(2));
            System.out.println("axis 4" + pad.getRawAxis(3));
        }else{

        }
    }
    public Command getAutonomousCommand() {
    
    return drivebase.getAutonomousCommand(path);    
    //return drivebase.getAutonomousCommand("Blue Playoffs Bonney Lake");    
    }
    public void SetPath(String pth){
        path = pth;
    }

}
