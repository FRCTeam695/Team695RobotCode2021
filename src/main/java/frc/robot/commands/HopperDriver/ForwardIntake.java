// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.HopperDriver;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.IntakeRake;

public class ForwardIntake extends CommandBase {
  /** Creates a new ForwardIntake. */
  IntakeRake IntakeRake_Inst;
  DoubleSupplier DriverRightTrigger;
  private ConditionalCommand HopperAction;
  //if trigger is lifted fully the command possibly may stop.
  public ForwardIntake(IntakeRake IntakeRake_Inst,Hopper Hopper_Inst, DoubleSupplier DriverRightTrigger, SequentialCommandGroup FullyIntakeBall, TakeInFourthPowerCell TakeInFourthPowerCell_Inst) {
    this.IntakeRake_Inst = IntakeRake_Inst;
    this.DriverRightTrigger =  DriverRightTrigger;
    this.HopperAction = 
    addRequirements(IntakeRake_Inst);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    IntakeRake_Inst.enableRake();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return this.DriverRightTrigger.getAsDouble() <= 0;
  }
}
