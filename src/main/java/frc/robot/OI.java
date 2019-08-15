package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveToPosition;
import frc.robot.commands.SetArm;
import frc.robot.commands.SetFlower;
import frc.robot.commands.ToggleArm;
import frc.robot.subsystems.Arm;
import frc.robot.commands.ToggleFlower;
import frc.robot.commands.ZeroElevator;
import frc.robot.commands.SetExtender;
import frc.robot.commands.ToggleExtender;
import frc.robot.subsystems.Flower;
import frc.robot.subsystems.Extender;
import harkerrobolib.wrappers.XboxGamepad;

public class OI {

    private static OI oi;
    
    private static final int DRIVER_PORT = 0;
    private static final int OPERATOR_PORT = 1;
    
    private XboxGamepad driverGamepad;
    private XboxGamepad operatorGamepad;
    
    private OI() {
        driverGamepad = new XboxGamepad(DRIVER_PORT);
        operatorGamepad = new XboxGamepad(OPERATOR_PORT);
        
        initBindings();
    }

    public static OI getInstance() {
        if(oi == null) {
            oi = new OI();
        }
        return oi;
    }

    public XboxGamepad getDriver() {
        return driverGamepad;
    }

    public XboxGamepad getOperator() {
        return operatorGamepad;
    }

    private void initBindings() {
        //driverGamepad.getButtonY().whenPressed(new DriveToPosition(12288));
        //driverGamepad.getButtonA().whenPressed(new ToggleArm());
        
        operatorGamepad.getButtonY().whenPressed(new SetFlower(Flower.FLOWER_OPEN));
        operatorGamepad.getButtonX().whenPressed(new SetFlower(Flower.FLOWER_CLOSED));
        //driverGamepad.getButtonX().whenPressed(new ToggleFlower());

        operatorGamepad.getButtonB().whenPressed(new SetExtender(Extender.EXTENDER_OUT));
        operatorGamepad.getButtonA().whenPressed(new SetExtender(Extender.EXTENDER_IN));
        //operatorGamepad.getButtonX().whenPressed(new ToggleExtender());
        
        operatorGamepad.getButtonBumperLeft().whenPressed(new ToggleFlower());
        operatorGamepad.getButtonBumperRight().whenPressed(new ToggleExtender());

        driverGamepad.getDownDPadButton().whenPressed(new ZeroElevator());

        //D-pad up for wrist position
        //operatorGamepad.DPAD_RIGHT_ANGLE().whenPressed(fjdkfj));
        //operatorGamepad.DPAD_LEFT_ANGLE().whenPressed(jkjkjk));
    }
}