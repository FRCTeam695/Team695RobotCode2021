// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Driving.ConventionalDrive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ConventionalDriveTrain;

public class MoveAtSpeedForSensorPosition extends CommandBase {
  /** Creates a new MoveAtSpeed. */
  ConventionalDriveTrain ConventionalDriveTrain_Inst;
  double speed;
  int targetSensorPosition;
  public MoveAtSpeedForSensorPosition(ConventionalDriveTrain ConventionalDriveTrain_Inst, double speed, int sensorPosition) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.ConventionalDriveTrain_Inst = ConventionalDriveTrain_Inst;
    this.speed = speed;
    this.targetSensorPosition = sensorPosition;
    addRequirements(ConventionalDriveTrain_Inst);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    ConventionalDriveTrain_Inst.zeroMotorSensorPositions();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    ConventionalDriveTrain_Inst.setUniformPower(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    ConventionalDriveTrain_Inst.setUniformPower(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return ConventionalDriveTrain_Inst.getRightFrontSensorPosition() >= targetSensorPosition;
  }
}
