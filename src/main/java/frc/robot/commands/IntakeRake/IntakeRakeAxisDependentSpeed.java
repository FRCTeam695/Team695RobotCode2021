// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.IntakeRake;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeRake;

public class IntakeRakeAxisDependentSpeed extends CommandBase {
  /** Creates a new IntakeRakeAxisDependentSpeed. */
  IntakeRake IntakeRake_Inst;
  DoubleSupplier DriverLeftTrigger;
  public IntakeRakeAxisDependentSpeed(IntakeRake IntakeRake_Inst,DoubleSupplier DriverLeftTrigger) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.IntakeRake_Inst = IntakeRake_Inst;
    this.DriverLeftTrigger = DriverLeftTrigger;
    addRequirements(IntakeRake_Inst);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    IntakeRake_Inst.setMotorPower(DriverLeftTrigger.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return DriverLeftTrigger.getAsDouble() <= 0.1;
  }
}
