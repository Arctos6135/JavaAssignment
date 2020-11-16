package com.arctos6135.robot.actuators;

import com.arctos6135.robot.RobotComponent;

/**
 * This is the abstract base class for all actuators.
 * 
 * An actuator is anything that moves, e.g. a motor.
 */
public abstract class AbstractActuator extends RobotComponent implements Actuator {
    // This class mostly serves to combine RobotComponent and Actuator
    // It currently contains nothing else, but if we want to we can easily
    // add logic into it in the future.
}
