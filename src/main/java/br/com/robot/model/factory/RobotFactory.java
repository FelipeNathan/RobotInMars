package br.com.robot.model.factory;

import org.springframework.stereotype.Component;

import br.com.robot.enums.Direction;
import br.com.robot.model.Coordinate;
import br.com.robot.model.Robot;

@Component
public class RobotFactory {

	public Robot createRobot() {
		Robot robot = new Robot();
		robot.setCoordinate(new Coordinate(0, 0));
		robot.setDirection(Direction.NORTH);
		return robot;
	}

}
