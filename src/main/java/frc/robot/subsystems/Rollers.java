package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.SpinRollers;
import harkerrobolib.wrappers.HSTalon;

public class Rollers extends Subsystem {

    private static Rollers rollers;
    
    private HSTalon wristTalon;
    private VictorSPX armVictor;
    
    private static final double DEFAULT_WRISTROLLERS_MAGNITUDE = 0;
    private static final double DEFAULT_ARMROLLERS_MAGNITUDE = 0;
    public static final double BUTTON_WRISTROLLERS_MAGNITUDE = 0;
    public static final double BUTTON_ARMROLLERS_MAGNITUDE = 0;;

    private Rollers() {
        wristTalon = new HSTalon(RobotMap.WRIST_TALON);
        armVictor = new VictorSPX(RobotMap.ARM_VICTOR);
        
    }

    public HSTalon getWristTalon() {
        return wristTalon;
    }

    public VictorSPX getArmVictor() {
        return armVictor;
    }
    
    public static Rollers getInstance() {
        if(rollers == null) {
            rollers = new Rollers();
        }
        return rollers;
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new SpinRollers(DEFAULT_WRISTROLLERS_MAGNITUDE, DEFAULT_ARMROLLERS_MAGNITUDE));
    }
}