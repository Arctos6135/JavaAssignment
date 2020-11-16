package com.arctos6135.robot.sensors;

import com.arctos6135.robot.RobotComponent;

/**
 * This is the abstract base class for all sensors.
 * 
 * A sensor provides data about its environment.
 */
public abstract class AbstractSensor extends RobotComponent implements Sensor {
    // This class mostly serves to combine RobotComponent and Sensor
    // It currently contains nothing else, but if we want to we can easily
    // add logic into it in the future.
}
