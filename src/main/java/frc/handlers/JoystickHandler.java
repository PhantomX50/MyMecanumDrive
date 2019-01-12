package frc.handlers;

import edu.wpi.first.wpilibj.Joystick;
import frc.subsystems.DriveTrain;

public class JoystickHandler
{
    private Joystick js = new Joystick(0);

    public JoystickHandler() 
    {
                
    }

    public void teleopUpdate(DriveTrain dt)
    {
        dt.drive(js.getX() * 0.99, js.getY() * 0.99, js.getZ() * 0.99);
    }
}