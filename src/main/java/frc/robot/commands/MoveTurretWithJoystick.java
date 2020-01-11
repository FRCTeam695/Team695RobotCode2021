/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ModelTurret;

public class MoveTurretWithJoystick extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
//  private final ModelTurret TurretControlled;
/*  private final int leftSideAxisID;
  private final int rightSideAxisID;
  private final Joystick Controller;*/
  ModelTurret TurretControlled;
  double horizontalAngle;
  double verticalAngle;
  Joystick Controller;
  /**
   * Creates a new SetTurretRotation.
   */
  public MoveTurretWithJoystick(ModelTurret TurretControlled,Joystick Controller,double horizontalAngle,double verticalAngle) {
    this.TurretControlled = TurretControlled;
    this.horizontalAngle = horizontalAngle;
    this.verticalAngle = verticalAngle;
    this.Controller = Controller;
    addRequirements(TurretControlled);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      TurretControlled.setXServoAngle(horizontalAngle);
      TurretControlled.setYServoAngle(verticalAngle);
    }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }


/*public MoveTurretWithJoystick(ModelTurret TurretControlled,Joystick Controller, int leftSideAxisID,int rightSideAxisID) {
  this.TurretControlled = TurretControlled;
  this.leftSideAxisID = leftSideAxisID;
  this.rightSideAxisID = rightSideAxisID;
  this.Controller = Controller;
  // Use addRequirements() here to declare subsystem dependencies.
  addRequirements(TurretControlled);
}*/
}
