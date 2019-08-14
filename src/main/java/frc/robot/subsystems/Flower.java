package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Flower extends Subsystem {

    private static Flower flower;
    private DoubleSolenoid solenoid;

    public static final DoubleSolenoid.Value FLOWER_OPEN = Value.kForward;
    public static final DoubleSolenoid.Value FLOWER_CLOSED = Value.kReverse;

    public Flower() {
        solenoid = new DoubleSolenoid(RobotMap.FLOWER_SOLENOID_FORWARD, RobotMap.FLOWER_SOLENOID_REVERSE);
    }

    public DoubleSolenoid.Value getState() {
        return solenoid.get();
    }

    public void setState(DoubleSolenoid.Value value) {
        solenoid.set(value);
    }

    public static Flower getInstance() {
        if(flower == null) {
            flower = new Flower();
        }
        return flower;
    }

    @Override
    protected void initDefaultCommand() {

    }
}