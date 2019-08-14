package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.subsystems.Flower;

public class ToggleFlower extends InstantCommand {

    public ToggleFlower() {
        requires(Flower.getInstance());
    }

    protected void initialize() {
        Flower.getInstance().setState((Flower.getInstance().getState() == Flower.FLOWER_CLOSED) ? (Flower.FLOWER_OPEN) : (Flower.FLOWER_CLOSED));
    }
}
