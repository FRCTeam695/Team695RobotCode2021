/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class encoderFalcon extends SubsystemBase {
  /**
   * Creates a new encoderFalcon.
   */
  private WPI_TalonFX Talon;
  public double distancePerPulse;
  public encoderFalcon(WPI_TalonFX Talon) {
    this.Talon = Talon;
    Talon.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
  }
  public void setDistancePerPulse(double distancePerPulse){
    this.distancePerPulse = distancePerPulse;
  }
  public void reset(){
    Talon.setSelectedSensorPosition(0);
  }
  public double getDistance(){
    return Talon.getSelectedSensorPosition()*distancePerPulse;
  }
  public double getRate(){
    return Talon.getSelectedSensorVelocity()*distancePerPulse;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}