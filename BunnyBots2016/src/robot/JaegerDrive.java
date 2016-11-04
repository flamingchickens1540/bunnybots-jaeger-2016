package robot;

import ccre.channel.BooleanInput;
import ccre.channel.BooleanOutput;
import ccre.channel.EventOutput;
import ccre.channel.FloatInput;
import ccre.channel.FloatOutput;
import ccre.ctrl.Drive;
import ccre.ctrl.ExtendedMotorFailureException;
import ccre.frc.FRC;

public class JaegerDrive {
	public static void setup() throws ExtendedMotorFailureException {
		
		FloatOutput leftDriveFront = FRC.talon(3);
    	FloatOutput leftDriveMiddle = FRC.talon(0);
    	FloatOutput leftDriveBack = FRC.talon(9);
    	FloatOutput rightDriveFront = FRC.talon(1);
    	FloatOutput rightDriveMiddle = FRC.talon(4);
    	FloatOutput rightDriveBack = FRC.talon(8);
    	
    	FloatInput driveRampingConstant = JaegerMain.mainTuning.getFloat("Drive Ramping Constant", .02f);
    	FloatOutput leftDrive = leftDriveFront.combine(leftDriveMiddle).combine(leftDriveBack).negate().addRamping(driveRampingConstant.get(), FRC.constantPeriodic);
    	FloatOutput rightDrive = rightDriveFront.combine(rightDriveMiddle).combine(rightDriveBack).addRamping(driveRampingConstant.get(),FRC.constantPeriodic);
    	
    	BooleanOutput shift = FRC.solenoid(0).combine(FRC.solenoid(1));

    	FloatInput leftDriveControls = JaegerMain.controlBinding.addFloat("Drive Left Axis").deadzone(0.2f);
    	FloatInput rightDriveControls = JaegerMain.controlBinding.addFloat("Drive Right Axis").deadzone(0.2f);
    	BooleanInput shiftingControls = JaegerMain.controlBinding.addBoolean("shiftingControls");
  
    	//Manual Shifting
    	shiftingControls.send(shift);
    	//FRC.encoder(aChannel, bChannel, reverse, resetWhen)
    	
    	//Tank Drive
		Drive.tank(leftDriveControls, rightDriveControls, leftDrive, rightDrive);
	}
}