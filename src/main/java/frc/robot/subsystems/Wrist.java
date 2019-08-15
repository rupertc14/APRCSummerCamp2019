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

    private static final boolean SENSOR_PHASE = false;

    private Wrist() {
        master = new HSTalon(RobotMap.WRIST_MASTER);
        follower = new VictorSPX(RobotMap.WRIST_FOLLOWER);
        talonInit();
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

        master.setSelectedSensorPosition(0);        
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