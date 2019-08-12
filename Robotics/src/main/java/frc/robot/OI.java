package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
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
}