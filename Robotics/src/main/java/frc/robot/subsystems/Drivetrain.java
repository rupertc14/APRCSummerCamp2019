package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.RobotMap;
import frc.robot.commands.DriveWithPercentOutput;
import harkerrobolib.subsystems.HSDrivetrain;
import harkerrobolib.wrappers.HSTalon;

public class Drivetrain extends HSDrivetrain {
    private static Drivetrain dt;
    
    private static final boolean INVERTED_MASTER_LEFT = false;
    private static final boolean INVERTED_MASTER_RIGHT = false;
    private static final boolean INVERTED_FOLLOWER_LEFT = true;
    private static final boolean INVERTED_FOLLOWER_RIGHT = false;
    
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
    }
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DriveWithPercentOutput());
    }
}