/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Constants;

/**
 * Add your docs here.
 */
public class Climb {
    private TalonSRX leftCreep;
    private TalonSRX rightCreep;
    private DoubleSolenoid rearSolenoid;
    private DoubleSolenoid frontSolenoid;

    public Climb(int leftCreepID, int rightCreepID, int frontSolonoidForward, int frontSolonoidReverse,
            int rearSolenoidForward, int rearSolenoidReverse) {
                
            leftCreep = new TalonSRX(leftCreepID);
            rightCreep = new TalonSRX(rightCreepID);
            frontSolenoid = new DoubleSolenoid(2, frontSolonoidForward, frontSolonoidReverse);
            rearSolenoid = new DoubleSolenoid(2, rearSolenoidForward, rearSolenoidReverse);
    }

    public Climb() {
        this(Constants.CREEP_LEFT_MOTOR_ID,
             Constants.CREEP_RIGHT_MOTOR_ID,
              Constants.CLIMB_FRONT_FW_CHANNEL,
                Constants.CLIMB_FRONT_RV_CHANNEL,
                 Constants.CLIMB_REAR_FW_CHANNEL,
                  Constants.CLIMB_REAR_RV_CHANNEL);
    }

    public void raiseFront() {
        frontSolenoid.set(Value.kForward);
    }

    public void retractFront() {
        frontSolenoid.set(Value.kReverse);
    }

    public void frontOff() {
        frontSolenoid.set(Value.kOff);
    }

    public void raiseRear() {
        rearSolenoid.set(Value.kForward);
    }

    public void retractRear() {
        rearSolenoid.set(Value.kReverse);
    }

    public void rearOff() {
        rearSolenoid.set(Value.kOff);
    }

    public void creepForward() {
        setCreep(.2);
    }

    public void stopCreep() {
        setCreep(0);
    }

    public void setCreep(double power) {
        leftCreep.set(ControlMode.PercentOutput, power);
        rightCreep.set(ControlMode.PercentOutput, power);
    }

    public void setLeft(double power) {
        leftCreep.set(ControlMode.PercentOutput, power);
    }
    
    public void setRight(double power) {
        rightCreep.set(ControlMode.PercentOutput, power);
    }
}
