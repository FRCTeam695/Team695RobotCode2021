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

public class ActivateTurretJoystickControl extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
//  private final ModelTurret TurretControlled;
/*  private final int leftSideAxisID;
  private final int rightSideAxisID;
  private final Joystick Controller;*/
  ModelTurret TurretControlled;
  Joystick Controller;
  int horizontalAxisId;
  int verticalAxisId;
  /**
   * Creates a new SetTurretRotation.
   */
  public ActivateTurretJoystickControl(ModelTurret TurretControlled,Joystick Controller,int horizontalAxisId,int verticalAxisId) {
    this.TurretControlled = TurretControlled;
    this.horizontalAxisId = horizontalAxisId;
    this.verticalAxisId = verticalAxisId;
    this.Controller = Controller;
    addRequirements(TurretControlled);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double horizontalInputConvertedToAngle = Controller.getRawAxis(horizontalAxisId) * 90.0;
    double verticalInputConvertedToAngle = Controller.getRawAxis(verticalAxisId) * 90.0;
    TurretControlled.setXServoAngle(horizontalInputConvertedToAngle);
  
    TurretControlled.setYServoAngle(verticalInputConvertedToAngle);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
