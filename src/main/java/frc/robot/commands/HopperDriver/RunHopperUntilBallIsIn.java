// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.HopperDriver;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;

public class RunHopperUntilBallIsIn extends CommandBase {
  Hopper Hopper_Inst;
  /** Creates a new IntakeBall. */
  public RunHopperUntilBallIsIn(Hopper Hopper_Inst) {
    this.Hopper_Inst = Hopper_Inst;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Hopper_Inst);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Hopper_Inst.resetHopperTach();
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Hopper_Inst.runHopper();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Hopper_Inst.stopHopper();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Hopper_Inst.getHopperTachValue() >= 1000;
  }
}
