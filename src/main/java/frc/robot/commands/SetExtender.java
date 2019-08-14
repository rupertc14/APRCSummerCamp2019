package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.subsystems.Extender;

public class SetExtender extends InstantCommand {
    
    private DoubleSolenoid.Value extenderValue;

    public SetExtender(DoubleSolenoid.Value extenderValue) {
        this.extenderValue = extenderValue;
    }

    @Override
    protected void initialize() {
        Extender.getInstance().setState(extenderValue);
    }
}