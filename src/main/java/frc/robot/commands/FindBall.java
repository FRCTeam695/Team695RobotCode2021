/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class FindBall extends CommandBase {
  /**
   * Creates a new FindBall.
   */
  BallDetector Detector;
  Motors MotorIntake;
  public FindBall(BallDetector Detector/*, Motors MotorIntake*/) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.Detector = Detector;
    //this.MotorIntake = MotorIntake;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //MotorIntake.spinIntake(Detector.get());
    if(Detector.get())
      System.out.println("False");
    else
      System.out.println("True");
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
  //test
}