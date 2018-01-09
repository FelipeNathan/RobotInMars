package br.com.robot.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.robot.enums.Direction;
import br.com.robot.exception.MovementException;
import br.com.robot.model.Area;
import br.com.robot.model.Robot;
import br.com.robot.service.interfaces.AreaService;
import br.com.robot.service.interfaces.RobotService;

@Service
public class RobotServiceImpl implements RobotService {

	@Autowired
	private AreaService areaService;

	private Area area;

	public void move(Robot robot, String route) throws Exception {

		this.area = areaService.createArea(4, 4);
		validateMovement(route);

		for (String movement : route.split("")) {
			switch (movement) {
			case "M":
				moveForward(robot);
				break;

			case "L":
				turnLeft(robot);
				break;

			case "R":
				turnRigth(robot);
				break;
			}
		}

	}

	private void moveForward(Robot robot) throws MovementException {

		int y = robot.getCoordinate().getY();
		int x = robot.getCoordinate().getX();

		switch (robot.getDirection()) {
		case NORTH:
			areaService.validateAreaLimit(area, ++y);
			robot.getCoordinate().setY(y);
			break;

		case SOUTH:
			areaService.validateAreaLimit(area, --y);
			robot.getCoordinate().setY(y);
			break;

		case EAST:
			areaService.validateAreaLimit(area, ++x);
			robot.getCoordinate().setX(x);
			break;

		case WEST:
			areaService.validateAreaLimit(area, --x);
			robot.getCoordinate().setX(x);
			break;
		}
	}

	private void turnRigth(Robot robot) {

		int ordinalDirection = robot.getDirection().ordinal();
		if (++ordinalDirection > 3) {
			ordinalDirection = 0;
		}

		robot.setDirection(Direction.getDirectionByOrdinal(ordinalDirection));
	}

	private void turnLeft(Robot robot) {

		int ordinalDirection = robot.getDirection().ordinal();
		if (--ordinalDirection < 0) {
			ordinalDirection = 3;
		}

		robot.setDirection(Direction.getDirectionByOrdinal(ordinalDirection));
	}

	private void validateMovement(String move) throws MovementException {

		if (StringUtils.isEmpty(move)) {
			throw new MovementException("Movimento não informado");
		}

		if (Pattern.matches("^.*[^MRL].*$", move)) {
			throw new MovementException("Há movimentos inválidos, os movimentos permitidos são: 'M', 'R' e 'L'");
		}
	}
}
