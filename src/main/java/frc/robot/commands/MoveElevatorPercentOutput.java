package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.subsystems.Elevator;
import harkerrobolib.commands.IndefiniteCommand;
import harkerrobolib.util.MathUtil;

public class MoveElevatorPercentOutput extends IndefiniteCommand {

    private double elevatorSpeed;
    
    public MoveElevatorPercentOutput() {
        requires(Elevator.getInstance());
    }

    @Override
    protected void execute() {
        elevatorSpeed = MathUtil.mapJoystickOutput(OI.getInstance().getDriver().getRightY(), RobotMap.DEADBAND);
        Elevator.getInstance().getMaster().set(ControlMode.PercentOutput, elevatorSpeed);
    }

    protected void Interrupted() {
        Elevator.getInstance().getMaster().set(ControlMode.Disabled, 0);
    }
}