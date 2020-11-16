package com.arctos6135.robot;

/**
 * An abstract base class for a robot component.
 * 
 * All robot components are connected to a port on the robot. This port must be
 * provided upon object creation and set in the constructor.
 */
public abstract class RobotComponent {
    /**
     * The port this actuator is on.
     */
    protected int port;

    /**
     * Gets the port this actuator is on.
     * 
     * @return The port this actuator is on
     */
    public int getPort() {
        return port;
    }
}
