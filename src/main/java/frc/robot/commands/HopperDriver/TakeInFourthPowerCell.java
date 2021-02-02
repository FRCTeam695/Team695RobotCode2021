// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.HopperDriver;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;

public class TakeInFourthPowerCell extends AllocateSpaceInHopperForNextCell {
  /** Creates a new AllocateSpaceInHopperForNextCell. */
  public TakeInFourthPowerCell(Hopper Hopper_Inst) {
    super(Hopper_Inst);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Hopper_Inst.isFull() || Hopper_Inst.getHopperTachValue() >= 2250;
  }
}
