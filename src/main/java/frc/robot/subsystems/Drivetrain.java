package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.RobotMap;
import frc.robot.commands.DriveWithPercentOutput;
import harkerrobolib.subsystems.HSDrivetrain;
import harkerrobolib.wrappers.HSTalon;

public class Drivetrain extends HSDrivetrain {
    private static Drivetrain dt;
    
    private static final boolean INVERTED_MASTER_LEFT = true;
    private static final boolean INVERTED_MASTER_RIGHT = false;
    private static final boolean INVERTED_FOLLOWER_LEFT = true;
    private static final boolean INVERTED_FOLLOWER_RIGHT = false;
    
    private static final boolean LEFT_SENSOR_PHASE = false;
    private static final boolean RIGHT_SENSOR_PHASE = false;
    private static final int MAX_VOLTAGE_COMPENSATION = 10;
    
    public static final int PRIMARY_INDEX = 0;
    public static final int POSITION_SLOT = 0;

    private static final double LEFT_POSITION_KP = 0;
    private static final double LEFT_POSITION_KI = 0;
    private static final double LEFT_POSITION_KD = 0;

    private static final double RIGHT_POSITION_KP = 0;
    private static final double RIGHT_POSITION_KI = 0;
    private static final double RIGHT_POSITION_KD = 0;
    
    private Drivetrain() {
        super(new HSTalon(RobotMap.DRIVETRAIN_MASTER_LEFT), 
            new HSTalon(RobotMap.DRIVETRAIN_MASTER_RIGHT), 
            new VictorSPX(RobotMap.DRIVETRAIN_FOLLOWER_LEFT), 
            new VictorSPX(RobotMap.DRIVETRAIN_FOLLOWER_RIGHT));
        talonInit();
    }

    public static Drivetrain getInstance() {
        if(dt == null) {
            dt = new Drivetrain();
        }
        
        return dt;
    }

    private void setupPositionPID() {
        getLeftMaster().config_kP(POSITION_SLOT, LEFT_POSITION_KP);
        getLeftMaster().config_kI(POSITION_SLOT, LEFT_POSITION_KI);
        getLeftMaster().config_kD(POSITION_SLOT, LEFT_POSITION_KD);
        
        getRightMaster().config_kP(POSITION_SLOT, RIGHT_POSITION_KP);
        getRightMaster().config_kI(POSITION_SLOT, RIGHT_POSITION_KI);
        getRightMaster().config_kD(POSITION_SLOT, RIGHT_POSITION_KD);
    }

    private void configVoltageComp() {
        getLeftMaster().configVoltageCompSaturation(MAX_VOLTAGE_COMPENSATION);
        getLeftMaster().enableVoltageCompensation(true);
        getRightMaster().configVoltageCompSaturation(MAX_VOLTAGE_COMPENSATION);
        getRightMaster().enableVoltageCompensation(true);
    }

    private void talonInit() {
        getLeftMaster().reset();
        getRightMaster().reset();

        getLeftMaster().setInverted(INVERTED_MASTER_LEFT);
        getLeftFollower().setInverted(INVERTED_FOLLOWER_LEFT);
        getRightMaster().setInverted(INVERTED_MASTER_RIGHT);
        getRightFollower().setInverted(INVERTED_FOLLOWER_RIGHT);
        
        getLeftMaster().follow(getLeftFollower());
        getRightMaster().follow(getRightFollower());

        getLeftMaster().setNeutralMode(NeutralMode.Brake);
        getRightMaster().setNeutralMode(NeutralMode.Brake);

        getLeftMaster().configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, PRIMARY_INDEX);
        getRightMaster().configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, PRIMARY_INDEX);

        getLeftMaster().setSensorPhase(LEFT_SENSOR_PHASE);
        getRightMaster().setSensorPhase(RIGHT_SENSOR_PHASE);
        
        configVoltageComp();

        setupPositionPID();
    }
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DriveWithPercentOutput());
    }
}