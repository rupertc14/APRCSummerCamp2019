package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import harkerrobolib.wrappers.HSTalon;;

public class Elevator extends Subsystem {

    private static Elevator elevator;

    private HSTalon master;
    private VictorSPX leftVictor;
    private VictorSPX rightVictor;
    
    private Elevator() {
        master = new HSTalon(RobotMap.ELEVATOR_MASTER);
        leftVictor = new VictorSPX(RobotMap.ELEVATOR_FOLLOWER_LEFT);
        rightVictor = new VictorSPX(RobotMap.ELEVATOR_FOLLOWER_RIGHT);
    }

    public HSTalon getMaster() {
        return master;
    }

    public VictorSPX getLeftVictor() {
        return leftVictor;
    }

    public VictorSPX getRightVictor() {
        return rightVictor;
    }
    
    public static Elevator getInstance() {
        if(elevator == null) {
            elevator = new Elevator();
        }
        return elevator;
    }

    @Override
    protected void initDefaultCommand() {

    }
}