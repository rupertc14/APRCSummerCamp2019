package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Elevator;

public class ZeroElevator extends Command {

    private static final double DOWN_SPEED = -0.1;

    public ZeroElevator() {
        requires(Elevator.getInstance());
    }
    
    @Override
    protected void execute() {
        Elevator.getInstance().getMaster().set(ControlMode.PercentOutput, DOWN_SPEED, DemandType.ArbitraryFeedForward, Elevator.FF_GRAV);
    }

    @Override
    protected boolean isFinished() {
        return (Elevator.getInstance().getMaster().getSelectedSensorVelocity() == 0);
    }

    @Override
    protected void interrupted() {
        Elevator.getInstance().getMaster().set(ControlMode.Disabled, 0);
    }

    @Override
    protected void end(){
        Elevator.getInstance().getMaster().set(ControlMode.Disabled, 0);
        Elevator.getInstance().getMaster().setSelectedSensorPosition(0);
    }
}