package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.subsystems.Extender;

public class ToggleExtender extends InstantCommand {
    public ToggleExtender() {
        requires (Extender.getInstance());
    }

    @Override
    protected void initialize() {
        Extender.getInstance().setState((Extender.getInstance().getState() == Extender.EXTENDER_IN) ? Extender.EXTENDER_OUT : Extender.EXTENDER_IN);
    }
}