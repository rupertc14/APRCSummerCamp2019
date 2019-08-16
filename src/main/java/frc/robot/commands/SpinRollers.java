package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Rollers;
import harkerrobolib.commands.IndefiniteCommand;

public class SpinRollers extends IndefiniteCommand {

    public static final double WRIST_ROLLERS_MAGNITUDE = 0;
    public static final double ARM_ROLLERS_MAGNITUDE = 0;
    
    private SpinRollers() {
        requires(Rollers.getInstance());
    }

    @Override
    protected void execute() {
        Rollers.getInstance().getWristTalon().set(ControlMode.PercentOutput, WRIST_ROLLERS_MAGNITUDE); 
        Rollers.getInstance().getArmVictor().set(ControlMode.PercentOutput, ARM_ROLLERS_MAGNITUDE);    
    }
}