package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;

import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.subsystems.Elevator;
import harkerrobolib.commands.IndefiniteCommand;
import harkerrobolib.util.MathUtil;

public class MoveElevatorPercentOutput extends IndefiniteCommand {

    private double elevatorSpeed;
    private static final double SPEED_MULTIPLIER = 0.3;

    public MoveElevatorPercentOutput() {
        requires(Elevator.getInstance());
    }

    @Override
    protected void execute() {
        elevatorSpeed = MathUtil.mapJoystickOutput(OI.getInstance().getDriver().getRightY(), RobotMap.DEADBAND);
        elevatorSpeed *= SPEED_MULTIPLIER;
        Elevator.getInstance().getMaster().set(ControlMode.PercentOutput, elevatorSpeed, DemandType.ArbitraryFeedForward, Elevator.FF_GRAV);
    }

    @Override
    protected void interrupted() {
        Elevator.getInstance().getMaster().set(ControlMode.Disabled, 0);
    }

    
}       