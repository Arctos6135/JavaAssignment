package com.arctos6135.robot.sensors;

/**
 * Base interface for all sensors.
 * 
 * A sensor provides data about its environment. All sensors should have a
 * method that provides the reading of the sensor.
 */
public interface Sensor {
    /**
     * Get the sensor reading.
     * 
     * @return The sensor's reading
     */
    public double getReading();
}
