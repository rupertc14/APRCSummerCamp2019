package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.subsystems.Wrist;
import harkerrobolib.commands.IndefiniteCommand;

public class MoveWristPercentOutput extends IndefiniteCommand {
   
    public MoveWristPercentOutput() {
        requires(Wrist.getInstance());
    }

    @Override
    public void execute() {
        
    }

    @Override
    public void interrupted() {
        Wrist.getInstance().getMaster().set(ControlMode.Disabled, 0);
    }
}