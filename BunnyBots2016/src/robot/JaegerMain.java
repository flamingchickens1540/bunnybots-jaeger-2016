package robot;

import ccre.channel.FloatInput;
import ccre.channel.FloatOutput;
import ccre.ctrl.ExtendedMotorFailureException;
import ccre.ctrl.binding.ControlBindingCreator;
import ccre.frc.FRC;
import ccre.frc.FRCApplication;
import ccre.log.Logger;
import ccre.tuning.TuningContext;

/**
 * This is the core class of a CCRE project. The CCRE launching system will make
 * sure that this class is loaded, and will have set up everything else before
 * loading it. If you change the name, use Eclipse's rename functionality. If
 * you don't, you will have to change the name in Deployment.java.
 *
 * Make sure to set {@link #TEAM_NUMBER} to your team number.
 */

public class JaegerMain implements FRCApplication {
	
	public static final ControlBindingCreator controlBinding = FRC.controlBinding();
	public static final TuningContext mainTuning = new TuningContext("MainTuning").publishSavingEvent();
    /**
     * This is where you specify your team number. It is used to find your
     * roboRIO when you download code.
     */
    public static final int TEAM_NUMBER = 1540;
    
    @Override
    public void setupRobot() throws ExtendedMotorFailureException {

    	Drive.setup();
    	
    }
}