# Final Java Assignment

Congratulations on making it through Java training!
You have now hopefully learned all the concepts you need to code for the robot.
To assess your understanding of the topics mentioned and to consolidate your learning, we have created a final assignment.

In order to make this exercise as realistic as possible to prepare you for working on the robot in the future, we have provided you with a set of fake API classes for a hypothetical robot, in the packages `com.arctos6135.robot`, `com.arctos6135.robot.sensors` and `com.arctos6135.robot.actuators`.

You will need to demonstrate your knowledge of Java concepts and the ability to make use of API classes with the help of documentation to complete this quiz.
Just like in real life, you can use any resources you want, so make use of those Googling skills!

**Note: Since the provided classes are part of the "API", you should assume that they *cannot* be changed. In real life, they will be sealed away in a Jar file and be read-only.**

## Setup

Click on the green "Code" button in the top-right corner of the GitHub page.
In it, select "Download ZIP", then extract the zip and open the extracted folder with VS Code.
That's all the setup you need for now!

## Documentation

To simulate a real environment, every class and package in the "API" provided has complete Javadocs.
They should be picked up by the autocompleter if you have VS Code set up properly.

If you want to view the full documentation, you can build it yourself.
On Windows, double click on `mkdoc.bat`. On Mac/Linux, run `sh mkdoc.sh`.
This will generate the full API documentation in the `docs` directory.
To view it, double click on `index.html` in `docs` to open it in a browser.

### Quick API Guide

Here's a quick guide to the API provided. For the full documentation see above.
* `com.arctos6135.robot` - Base package for everything in the API.
  * `AbstractRobot` - An abstract robot base that you should implement later.
  * `NameNotSetException` - An exception thrown by the robot class.
  * `RobotComponent` - An abstract class for all "components" on the robot (including sensors and actuators).
  * `Task` - A functional interface for a task that the robot can do.
  * `TaskExecutionException` - An exception thrown by the robot class.
  * `com.arctos6135.robot.actuators` - Package for actuators, or things that move.
    * `Actuator` - An interface for all actuators.
    * `AbstractActuator` - An abstract base class for all actuators.
    * `Motor` - A motor.
  * `com.arctos6135.robot.sensors` - Package for sensors, or things that provide info about their environment.
    * `Sensor` - An interface for all sensors.
    * `AbstractSensor` - An abstract base class for all sensors.
    * `Encoder` - A sensor that measures shaft rotation, which is then converted into distance.
    * `Gyroscope` - A sensor that measures angular velocity, which is then converted into an angle.

## Your Tasks

### 0. Demo: Make an implementation of `Actuator` for a `Servo` class

As a demo, we will make a new actuator class called `Servo`.
This class will inherit from `AbstractActuator`.

You can think of a servo like a motor that you can set to a precise angle but has a limited range.

### 1. Warm up: Make an implementation of `Sensor` for a `Timer` class

Make a new sensor class called `Timer`.
Note: Since timers aren't physical components, you can implement `Sensor` directly instead of inheriting from `AbstractSensor`, since the latter requires you to set up a port.

In addition to the required methods, it should also provide a `reset()` method that resets the timer to 0.
In its `getReading()` method, return the number of milliseconds elapsed since the timer was last reset.
The timer should be reset on instantiation.
Hint: `System.currentTimeMillis()` returns the current time in milliseconds.

### 2. Make a concrete implementation of the `AbstractRobot` class

Your implementation can have any name you want (although you should pretend that this is the actual robot code, so try to give it a good name).
It should be located in the package `com.arctos6135.robot`.

This would mean providing an implementation to `getLeftWheelDistance()`, `getRightWheelDistance()` and `getHeading()`.
You should use the `com.arctos6135.robot.sensors.Encoder` class to obtain distance readings, and the `com.arctos6135.robot.sensors.Gyroscope` class to obtain heading (direction) readings.
Remember that when creating a sensor or actuator you need to specify where it's connected to!
The encoders for the left and right wheels are on **ports 2 and 3**, respectively, and the gyroscope is on **port 4**.

But there's a catch!
`Encoder` returns distances in inches, but `getLeftWheelDistance()` and `getRightWheelDistance()` should return centimeters (2.54cm = 1in).
`Gyroscope` returns a continuous angle; that is, it can be greater than 360 or less than 0, but `getHeading()` should return angles only in the range [0, 360].

Your implementation should also have two motors, one for the left side of the robot and one for the right. 
(Use the `com.arctos6135.robot.actuators.Motor` class to create a motor.)
These two motors should be on **ports 0 and 1**, respectively. 

### 3. Add a state variable to your robot

Your robot implementation should have a state variable with 3 possible values - enabled, disabled and unknown.
You should make an enum for this. You can either put the enum in the same package or nested inside the robot class itself.
When the robot is first created, it should be disabled.
You should provide getters and setters and make it not directly accessible from outside the class for encapsulation.

### 4. Make the robot "do something cool".

Create a class in the `com.arctos6135.robot` package that has a main method.
In this class, create a function that can take in **any robot (not just your specific implementation)** and calls `com.arctos6135.robot.Robot.doSomethingCool()` on that robot.
Note that `doSomethingCool()` will throw an exception if the name of the robot is not set, so make sure you call `setName()` in the robot constructor.

Call this function that you just created with an instance of your robot implementation.

### 5. Make a robot do a task.

Finally, make the robot "do a task" by using the `com.arctos6135.robot.Robot.doTask()` method.
Use a lambda.

In the task, you should check the "state" variable of the robot, and:
* If the robot is enabled, then set the speed of the left and right motors to something.
* If the robot is disabled, do nothing.
* If the robot state is unknown, throw a `TaskExecutionException` with a helpful message.

---

When you're done, DM us the code in a zip for review.
If you have any questions, contact @tylertian or @jeremy_xie on Ryver.
Good luck!
