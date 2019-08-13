package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Drivetrain;

public class DriveToPosition extends Command {
    
    private int setpoint;
    private static final int ALLOWABLE_ERROR = 100;

    public DriveToPosition(int finalPosition) {
        requires(Drivetrain.getInstance());
        setpoint = finalPosition;
    }

    @Override
    protected void initialize() {
        Drivetrain.getInstance().getLeftMaster().selectProfileSlot(Drivetrain.POSITION_SLOT, Drivetrain.PRIMARY_INDEX);
        Drivetrain.getInstance().getRightMaster().selectProfileSlot(Drivetrain.POSITION_SLOT, Drivetrain.PRIMARY_INDEX);
        Drivetrain.getInstance().getLeftMaster().setSelectedSensorPosition(0);
        Drivetrain.getInstance().getRightMaster().setSelectedSensorPosition(0);
    }

    @Override
    protected void execute() {
        Drivetrain.getInstance().getLeftMaster().set(ControlMode.Position, setpoint);
        Drivetrain.getInstance().getRightMaster().set(ControlMode.Position, setpoint);
    }
    
    @Override
    protected boolean isFinished() {
        return (setpoint - Drivetrain.getInstance().getLeftMaster().getSelectedSensorPosition() <= ALLOWABLE_ERROR && 
            setpoint - Drivetrain.getInstance().getRightMaster().getSelectedSensorPosition() <= ALLOWABLE_ERROR);
    }
}