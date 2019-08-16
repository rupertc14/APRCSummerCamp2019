package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Rollers;
import harkerrobolib.commands.IndefiniteCommand;

public class SpinRollers extends IndefiniteCommand {

<<<<<<< HEAD
    private double wristMagnitude;
    private double armMagnitude;

    public SpinRollers(double wristMagnitude, double armMagnitude) {
=======
    public static final double WRIST_ROLLERS_MAGNITUDE = 0;
    public static final double ARM_ROLLERS_MAGNITUDE = 0;
    
    public SpinRollers() {
>>>>>>> 32106ea4f8226bc8bbffca2ba2fc78e6950dc72d
        requires(Rollers.getInstance());
        this.wristMagnitude = wristMagnitude;
        this.armMagnitude = armMagnitude;
    }

    @Override
    protected void execute() {
        Rollers.getInstance().getWristTalon().set(ControlMode.PercentOutput, wristMagnitude); 
        Rollers.getInstance().getArmVictor().set(ControlMode.PercentOutput, armMagnitude);     
    }
}