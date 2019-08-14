package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.subsystems.Flower;

public class SetFlower extends InstantCommand {

    private DoubleSolenoid.Value flowerValue;

    public SetFlower(DoubleSolenoid.Value flowerValue) {
        this.flowerValue = flowerValue;
    }

    protected void initialize() {
       Flower.getInstance().setState(flowerValue); 
    }
}