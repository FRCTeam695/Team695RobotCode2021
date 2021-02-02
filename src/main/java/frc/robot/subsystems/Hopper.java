// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Hopper extends SubsystemBase {
  private Counter HopperTach = new Counter(1);
  //has BACKWARDS direction
  private AdjustableVictor HopperVictor = new AdjustableVictor(6);
  private DigitalInput HopperEntrySensor = new DigitalInput(0);
  private int hopperCount = 0;
  
  /** Creates a new Hopper. */
  public Hopper(Counter hoppertach,AdjustableVictor HopperVictor, DigitalInput HopperEntrySensor) {
    this.HopperTach = hoppertach;
    this.HopperVictor = HopperVictor;
    this.HopperEntrySensor = HopperEntrySensor;
  }

  public int getHopperTachValue() {
    return this.HopperTach.get();
  }

  public void incrementHopperCount(){
    hopperCount++;
  }

  public int getHopperCount() {
    return hopperCount;
  }

  public void runHopper(){
    HopperVictor.setPower(Constants.HopperSettings.HOPPER_SPEED);
  }

  public void stopHopper(){
    HopperVictor.setPower(0);
  }

  public boolean powerCellInSensor(){
    return !HopperEntrySensor.get();
  }

  public boolean isFull(){
    return hopperCount >= 4;
  }

  public boolean almostAtCapacity(){
    return hopperCount == 3;
  }

  public void resetHopperTach(){
    this.HopperTach.reset();
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
