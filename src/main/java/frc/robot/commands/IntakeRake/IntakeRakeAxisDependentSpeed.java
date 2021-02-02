// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.IntakeRake;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.enums.RotationDirection;
import frc.robot.subsystems.IntakeRake;

public class IntakeRakeAxisDependentSpeed extends CommandBase {
  /** Creates a new IntakeRakeAxisDependentSpeed. */
  IntakeRake IntakeRake_Inst;
  DoubleSupplier DriverLeftTrigger, DriverRightTrigger;
  RotationDirection RotationDirectionUsed;

  public IntakeRakeAxisDependentSpeed(IntakeRake IntakeRake_Inst,DoubleSupplier DriverLeftTrigger,DoubleSupplier DriverRightTrigger) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.IntakeRake_Inst = IntakeRake_Inst;
    this.DriverLeftTrigger = DriverLeftTrigger;
    this.DriverRightTrigger = DriverRightTrigger;
    addRequirements(IntakeRake_Inst);
  }



  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (DriverLeftTrigger.getAsDouble() > 0.1) {
      IntakeRake_Inst.setMotorPower(-1*DriverLeftTrigger.getAsDouble());
    } else{
      IntakeRake_Inst.setMotorPower(DriverRightTrigger.getAsDouble());
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return DriverLeftTrigger.getAsDouble() <= 0.1 && DriverRightTrigger.getAsDouble() <= 0.1;
  }
}
