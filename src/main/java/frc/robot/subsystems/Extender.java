package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;;


public class Extender extends Subsystem {

    private static Extender extender;
    private DoubleSolenoid solenoid;

    public static final DoubleSolenoid.Value EXTENDER_OUT = Value.kForward;
    public static final DoubleSolenoid.Value EXTENDER_IN = Value.kReverse;

    private Extender() {
        solenoid = new DoubleSolenoid(RobotMap.EXTENDER_SOLENOID_FORWARD, RobotMap.EXTENDER_SOLENOID_REVERSE);
    }

    public static Extender getInstance() {
        if(extender == null) {
            extender = new Extender();
        }
        return extender;
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