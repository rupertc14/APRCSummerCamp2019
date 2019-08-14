package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.subsystems.Arm;

public class SetArm extends InstantCommand {

    private DoubleSolenoid.Value desiredValue;   
    
    public SetArm(DoubleSolenoid.Value desiredValue) {
        this.desiredValue = desiredValue;
    }

    @Override
    protected void initialize() {
        Arm.getInstance().setState(desiredValue);
    }

}