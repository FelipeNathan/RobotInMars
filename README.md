# Robot In Mars
This is an API to move your WALL-E on mars. The robot will move on a 5x5 field and return the position.

## Requirements
* SpringBoot
* JUnit
* Java 8
* Maven

## Installation
Install the dependencies with maven: `Run as → Maven Build → Goals: clean install` </br>
Run the project `Run as → Maven Build → Goals: spring-boot:run`

## Usage
The application will start in port 8080 and the uri is "/rest/mars/{route}" </br>
The API accept only POST request 


### Parameter
The parameter is the movements of your robot, you can use three letters to tell your robot how to move on his coordinate (x, y, d):
* R - Change the direction of your robot to right 
  * Ex: Turn from North to East
* L - Change the direction of your robot to left 
  * Ex: Turn from North to West
* M - Move your robot forward according with his direction
  * North and South: axis Y
  * East and West: axis X

### Example
The robot of this application starts in position (0, 0, N)

curl -s --request POST http://localhost:8080/rest/mars/MMRMMRMM </br>
return: (2, 0, S)

curl -s --request POST http://localhost:8080/rest/mars/MML </br>
return: (0, 2, W)
