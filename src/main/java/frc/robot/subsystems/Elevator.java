package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.MoveElevatorPercentOutput;
import harkerrobolib.wrappers.HSTalon;;

public class Elevator extends Subsystem {

    private static Elevator elevator;

    private HSTalon master;
    private VictorSPX leftVictor;
    private VictorSPX rightVictor;
    private HSTalon talonFollower;
    
    private static final boolean INVERSION_MASTER = true;
    private static final boolean INVERSION_FOLLOWER_TALON = true;
    private static final boolean INVERSION_FOLLOWER_LEFT = true;
    private static final boolean INVERSION_FOLLOWER_RIGHT = true;

    private static final boolean SENSOR_PHASE = false;
    
    public static final double FF_GRAV = 0;

    private Elevator() {
        master = new HSTalon(RobotMap.ELEVATOR_MASTER);
        talonFollower = new HSTalon(RobotMap.ELEVATOR_TALON_FOLLOWER);
        leftVictor = new VictorSPX(RobotMap.ELEVATOR_FOLLOWER_LEFT);
        rightVictor = new VictorSPX(RobotMap.ELEVATOR_FOLLOWER_RIGHT);
        talonInit();
    }

    public HSTalon getMaster() {
        return master;
    }

    public HSTalon getTalonFollower() {
        return talonFollower;
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

    private void talonInit() {
        master.reset();
        talonFollower.reset();
        
        master.setInverted(INVERSION_MASTER);
        talonFollower.setInverted(INVERSION_FOLLOWER_TALON);
        leftVictor.setInverted(INVERSION_FOLLOWER_LEFT);
        rightVictor.setInverted(INVERSION_FOLLOWER_RIGHT);
        
        talonFollower.follow(master);
        leftVictor.follow(master);
        rightVictor.follow(master);

        master.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        master.setSensorPhase(SENSOR_PHASE);

        master.setSelectedSensorPosition(0);
    }
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new MoveElevatorPercentOutput());
    }
}