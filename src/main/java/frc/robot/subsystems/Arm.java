package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Arm extends Subsystem {
    
    private static Arm arm;
    private DoubleSolenoid solenoid;
    
    public static final DoubleSolenoid.Value ARM_OUT = Value.kForward;
    public static final DoubleSolenoid.Value ARM_IN = Value.kReverse;

    private Arm() {
        solenoid = new DoubleSolenoid(RobotMap.ARM_SOLENOID_FORWARD, RobotMap.ARM_SOLENOID_REVERSE);
    }

    public static Arm getInstance() {
        if(arm == null) {
            arm = new Arm();
        }
        return arm;
    }

    public DoubleSolenoid.Value getState() {
        return solenoid.get();
    }

    public void setState(DoubleSolenoid.Value value) {
        solenoid.set(value);
    }

    public DoubleSolenoid getSolenoid() {
        return solenoid;
    }

    @Override
    protected void initDefaultCommand() {

    }
}