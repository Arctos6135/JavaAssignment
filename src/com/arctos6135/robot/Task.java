package com.arctos6135.robot;

/**
 * A task that a {@link AbstractRobot Robot} can do.
 */
@FunctionalInterface
public interface Task {

    /**
     * Does the task.
     * 
     * @param robot The robot that is doing the task
     */
    public void doIt(AbstractRobot robot);
}
