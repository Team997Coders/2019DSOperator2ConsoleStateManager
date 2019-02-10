# 2019DSOperator2ConsoleStateManager
This project implements a command line application that listens for custom
firmware joystick button clicks from the [2019DSOperator2Console](https://github.com/Team997Coders/2019DSOperator2Console)
project and pretends to be the roborio by hooking up a fakey activate command, 
such that when the activate button on the custom operator console is pressed, the
command spews out the state of the console.

## To Use
1. Load firmware on a Teensy 3.5 as documented in project above.
2. You need to have buttons and LEDs connected to the Teensy as indicated within the firmware (document here for convenience.)
3. Run this application with `./gradlew run`. Observe the console when presseing the activate button. The spewed state should match the
state of the LEDs.