package com.arctos6135.robot.actuators;

/**
 * Base interface for all actuators.
 * 
 * An actuator is anything that moves, e.g. a motor. All actuators should have a
 * method that sets its output.
 */
public interface Actuator {
    /**
     * Set the output of this actuator.
     * 
     * @param output The amount of output
     */
    public void setOutput(double output);
}
