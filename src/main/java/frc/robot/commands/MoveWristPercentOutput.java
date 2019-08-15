package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.subsystems.Wrist;
import harkerrobolib.commands.IndefiniteCommand;
import harkerrobolib.util.MathUtil;



public class MoveWristPercentOutput extends IndefiniteCommand {

    private static final double SPEED_MULTIPLIER = 0.2;
   
    public MoveWristPercentOutput() {
        requires(Wrist.getInstance());
    }

    @Override
    public void execute() {
         double wristSpeed = MathUtil.mapJoystickOutput(OI.getInstance().getOperator().getRightX(), RobotMap.OPERATOR_DEADBAND) * SPEED_MULTIPLIER;
    }

    @Override
    public void interrupted() {
        Wrist.getInstance().getMaster().set(ControlMode.Disabled, 0);
    }
}