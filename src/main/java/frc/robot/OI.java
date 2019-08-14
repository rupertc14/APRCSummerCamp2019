package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveToPosition;
import frc.robot.commands.SetArm;
import frc.robot.commands.ToggleArm;
import frc.robot.subsystems.Arm;
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
        driverGamepad.getButtonA().whenPressed(new ToggleArm());
        driverGamepad.getButtonB().whenPressed(new SetArm(Arm.ARM_IN));
        driverGamepad.getButtonX().whenPressed(new SetArm(Arm.ARM_OUT));
    }
}