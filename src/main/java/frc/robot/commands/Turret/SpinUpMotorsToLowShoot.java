// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;

public class SpinUpMotorsToLowShoot extends CommandBase {
  private Turret Turret_Inst;
  /** Creates a new SpinUpMotors. */
  public SpinUpMotorsToLowShoot(Turret Turret_Inst) {
    this.Turret_Inst = Turret_Inst;
    addRequirements(Turret_Inst);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Turret_Inst.spinUpMotorsToLowShootSpeeds();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Turret_Inst.motorsAtSetpoint();
  }
}
