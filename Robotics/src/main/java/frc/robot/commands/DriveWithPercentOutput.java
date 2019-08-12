package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;
import harkerrobolib.commands.IndefiniteCommand;
import harkerrobolib.util.MathUtil;

public class DriveWithPercentOutput extends IndefiniteCommand {
    
    public DriveWithPercentOutput() {
        requires(Drivetrain.getInstance());
    }
    
    @Override
    protected void execute() {
        double speed = MathUtil.mapJoystickOutput(OI.getInstance().getDriver().getLeftY(), RobotMap.DEADBAND);
        double turn = MathUtil.mapJoystickOutput(OI.getInstance().getOperator().getLeftX(), RobotMap.DEADBAND);
        
        Drivetrain.getInstance().getLeftMaster().set(ControlMode.PercentOutput, speed+turn);
        Drivetrain.getInstance().getRightMaster().set(ControlMode.PercentOutput, speed-turn);
    }
}