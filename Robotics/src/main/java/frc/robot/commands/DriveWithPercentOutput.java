package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.OI;
import frc.robot.subsystems.Drivetrain;
import harkerrobolib.commands.IndefiniteCommand;

public class DriveWithPercentOutput extends IndefiniteCommand {
    
    public DriveWithPercentOutput() {
        requires(Drivetrain.getInstance());
    }
    
    @Override
    protected void execute() {
        double speed = OI.getInstance().getDriver().getLeftY();
        double turn = OI.getInstance().getOperator().getLeftX();
        
        Drivetrain.getInstance().getLeftMaster().set(ControlMode.PercentOutput, speed+turn);
        Drivetrain.getInstance().getRightMaster().set(ControlMode.PercentOutput, speed-turn);
    }
}