package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Rollers;
import harkerrobolib.commands.IndefiniteCommand;

public class SpinRollers extends IndefiniteCommand {

    private double armMagnitude;

    public SpinRollers(double wristMagnitude, double armMagnitude) {
        requires(Rollers.getInstance());
        Rollers.getInstance().getWristTalon().set(ControlMode.PercentOutput, wristMagnitude); 
        Rollers.getInstance().getArmVictor().set(ControlMode.PercentOutput, armMagnitude);     
    }
}