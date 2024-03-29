package frc.robot;

public class RobotMap {
    
    //CAN IDs - Drivetrain
    public static final int DRIVETRAIN_FOLLOWER_LEFT = 2;
    public static final int DRIVETRAIN_FOLLOWER_RIGHT = 1;
    public static final int DRIVETRAIN_MASTER_LEFT = 4;
    public static final int DRIVETRAIN_MASTER_RIGHT = 6;
    
    //CAN IDs - Elevator
    public static final int ELEVATOR_MASTER = 2;
    public static final int ELEVATOR_TALON_FOLLOWER = 3;
    public static final int ELEVATOR_FOLLOWER_LEFT = 3;
    public static final int ELEVATOR_FOLLOWER_RIGHT = 5;

    //CAN IDs - Wrist
    public static final int WRIST_MASTER = 5;
    public static final int WRIST_FOLLOWER = 7;

    //CAN IDs - Rollers
    public static final int WRIST_TALON = 1;
    public static final int ARM_VICTOR = 0;
    
    //Pneumatics IDs
    public static final int ARM_SOLENOID_FORWARD = 4;
    public static final int ARM_SOLENOID_REVERSE = 0;

    public static final int FLOWER_SOLENOID_FORWARD = 1;
    public static final int FLOWER_SOLENOID_REVERSE = 5;
    
    public static final int EXTENDER_SOLENOID_FORWARD = 6;
    public static final int EXTENDER_SOLENOID_REVERSE = 2;
        
    public static final double DRIVER_DEADBAND = 0.1;
    public static final double OPERATOR_DEADBAND = 0.1;
}