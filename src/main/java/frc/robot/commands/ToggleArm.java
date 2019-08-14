package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.subsystems.Arm;

public class ToggleArm extends InstantCommand {

    public ToggleArm() {
        requires(Arm.getInstance());
    }

    @Override
    protected void initialize() {
        Arm.getInstance().setState((Arm.getInstance().getState() == Arm.ARM_IN) ? Arm.ARM_OUT : Arm.ARM_IN);
    }
}