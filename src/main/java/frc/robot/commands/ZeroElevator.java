package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Elevator;

public class ZeroElevator extends Command {

    private double startTime; 

    private static final double DOWN_SPEED = -0.1;
    private static final double INVALID_TIME = 0.1;

    public ZeroElevator() {
        requires(Elevator.getInstance());
    }

    @Override
    protected void initialize() {
        startTime = Timer.getFPGATimestamp();
        Elevator.getInstance().getMaster().configForwardSoftLimitEnable(false);
        ;
    }
    
    @Override
    protected void execute() {
        Elevator.getInstance().getMaster().set(ControlMode.PercentOutput, DOWN_SPEED, DemandType.ArbitraryFeedForward, Elevator.FF_GRAV);
    }

    @Override
    protected boolean isFinished() {
        return (Timer.getFPGATimestamp() - startTime >= INVALID_TIME && Elevator.getInstance().getMaster().getSelectedSensorVelocity() == 0); 
    }
                                                                             
    @Override
    protected void interrupted() {
        Elevator.getInstance().getMaster().set(ControlMode.Disabled, 0);
    }

    @Override
    protected void end(){
        Elevator.getInstance().getMaster().set(ControlMode.Disabled, 0);
        Elevator.getInstance().getMaster().setSelectedSensorPosition(0);
        Elevator.getInstance().getMaster().configForwardSoftLimitEnable(true);
        Elevator.getInstance
    }
}