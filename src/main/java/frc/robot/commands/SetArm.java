package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.subsystems.Arm;

public class SetArm extends InstantCommand {

    private DoubleSolenoid.Value armValue;   
    
    public SetArm(DoubleSolenoid.Value armValue) {
        this.armValue = armValue;
    }

    @Override
    protected void initialize() {
        Arm.getInstance().setState(armValue);
    }

}