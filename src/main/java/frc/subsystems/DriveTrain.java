package frc.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.mecanum.Mecanum;

public class DriveTrain
{
    private WPI_TalonSRX frontR;
    private WPI_TalonSRX frontL;
    private WPI_TalonSRX rearR;
    private WPI_TalonSRX rearL;

    private Mecanum mecanum = new Mecanum(frontL, rearL, frontR, rearR);

    public DriveTrain()
    {

    }

    public void drive(double xSpeed, double ySpeed, double zRotation)
    {
        mecanum.driveCartesian(xSpeed, ySpeed, zRotation);
    }
}