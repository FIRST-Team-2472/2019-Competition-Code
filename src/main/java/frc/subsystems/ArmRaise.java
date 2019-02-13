/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Constants;

/**
 * Add your docs here.
 */
public class ArmRaise {

    private DoubleSolenoid doubleSolenoid;

    public ArmRaise(int pcmId, int forwardChannel, int reverseChannel) {
        doubleSolenoid = new DoubleSolenoid(pcmId, forwardChannel, reverseChannel);
    }

    public ArmRaise() {
        this(2, Constants.ARM_RAISER_FORWARD_CHANNEL, Constants.ARM_RAISER_REVERSE_CHANNEL);
    }

    public void up() {
        System.out.println("Up (inside class)!!");
        doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void down() {
        System.out.println("Down (inside class)!!");
        doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
}
