// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.HopperDriver;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;

//todo: potentially determine how much to shoot based on hopper's call counter reading
public class UnloadFullHopperIntoShooter extends AllocateSpaceInHopperForNextCell {
  /** Creates a new AllocateSpaceInHopperForNextCell. */
  public UnloadFullHopperIntoShooter(Hopper Hopper_Inst) {
    super(Hopper_Inst);
  }

  @Override
  public void end(boolean interrupted) {
    Hopper_Inst.stopHopper();
    Hopper_Inst.zeroHopperCount();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Hopper_Inst.getHopperTachValue() >= 25000;
  }
}
