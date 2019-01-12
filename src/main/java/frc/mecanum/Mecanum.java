package frc.mecanum;

import edu.wpi.first.wpilibj.SpeedController;

public class Mecanum
{
    private SpeedController fr;
    private SpeedController fl;
    private SpeedController br;
    private SpeedController bl;

    private double scales[] = {1.0, 1.0, 1.0, 1.0}; //index corrolates to motor in counter-clockwise pattern

    public Mecanum(SpeedController frontLeftMotor, SpeedController rearLeftMotor, SpeedController frontRightMotor, SpeedController rearRightMotor)
    {
        fr = frontRightMotor;
        fl = frontLeftMotor;
        br = rearRightMotor;
        bl = rearLeftMotor;
    }

    public void driveCartesian(double ySpeed, double xSpeed, double zRotation)
    {
        fr.set(((ySpeed-xSpeed-zRotation)/3) * scales[0]);
        fl.set(((ySpeed+xSpeed+zRotation)/3) * scales[1]);
        br.set(((ySpeed+xSpeed-zRotation)/3) * scales[2]);
        bl.set(((ySpeed-xSpeed+zRotation)/3) * scales[3]);
    }

    public void setInverse(int motor) //motors are in the same pattern as Cartesian quadrants
    {
        if (motor == 0)
            fr.setInverted(true);
        else if (motor == 1)
            fl.setInverted(true);
        else if (motor == 2)
            bl.setInverted(true);
        else if (motor == 3)
            br.setInverted(true);
    }

    public void setScale(int motor, double scale) //from -1.0 to 1.0
    {
        if (scale > 1.0)
            scale = 1.0;
        
        if (scale < -1.0)
            scale = -1.0;

        if (motor < 0)
            motor = 0;
        
        if (motor > 3)
            motor = 3;

        scales[motor] = scale;
    }
}