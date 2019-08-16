package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import harkerrobolib.wrappers.HSTalon;
import frc.robot.RobotMap;

public class Wrist extends Subsystem {

    private static Wrist wrist;
    
    private HSTalon master;
    private VictorSPX follower;

    private static final boolean INVERSION_MASTER = false;
    private static final boolean INVERSION_FOLLOWER = false;

    private static final boolean SENSOR_PHASE = true;
    
    private static final double HORIZONTAL_FRONT = 130;
    private static final double HORIZONTAL_BACK = 2160; 
    private static final double FRONTMOST_POSITION = 0;
    private static final double BACKMOST_POSITION = 0;

    private static final double UPPER_SOFT_LIMIT = 0;
    private static final double LOWER_SOFT_LIMIT = 0;

    private static final double FF_GRAV_MULTIPLIER = 0;

    private Wrist() {
        master = new HSTalon(RobotMap.WRIST_MASTER);
        follower = new VictorSPX(RobotMap.WRIST_FOLLOWER);
        talonInit();
    }

    public double convertTickstoDegrees(int t) {

    }

    public HSTalon getMaster() {
        return master;
    }

    private void talonInit() {
        master.reset();

        master.setInverted(INVERSION_MASTER);
        follower.setInverted(INVERSION_FOLLOWER);

        follower.follow(master);

        master.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        master.setSensorPhase(SENSOR_PHASE);      

        master.configForwardSoftLimitThreshold(UPPER_SOFT_LIMIT);
        master.configReverseSoftLimitThreshold(LOWER_SOFT_LIMIT);
        master.configForwardSoftLimitEnable(true);
        master.configReverseSoftLimitEnable(true);
    }
        
    public static Wrist getInstance() {
        if(wrist == null) {
            wrist = new Wrist();
        }
        return wrist;
    }

    

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new MoveWristPercentOutput());
    }  
}