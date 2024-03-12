# RoboticArm controller
This repository is for a software that is used to control a robotic arm over a serial USB connection.\
the program runs in Java whilst the robot arm uses an arduino to interpret the serial data from the controller and calculate its relative position and required movements (Inverse kinematics).

## About the robot
This is a palletizer style robot, it offers 3 degrees of freedom whilst keeping the tip of the robotic arm directly perpendicular to the plane that the robot sits on, it is a mix between few different robots and some custom designed parts
The robot runs on a standard Nema 17 steppers

<img src="./RobotDesktop/images/Robot%201.jpeg" alt="Robot palletizer unassembled" height="500" >
<img src="./RobotDesktop/images/Robot%202.jpeg" alt="Robot palletizer assembled" height="500">