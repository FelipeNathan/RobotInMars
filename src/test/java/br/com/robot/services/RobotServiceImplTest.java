package br.com.robot.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.robot.enums.Direction;
import br.com.robot.exception.MovementException;
import br.com.robot.model.Coordinate;
import br.com.robot.model.Robot;
import br.com.robot.model.factory.RobotFactory;
import br.com.robot.service.interfaces.RobotService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RobotServiceImplTest {

	private Robot robot;
	
	@Autowired
	private RobotFactory robotFactory;

	@Autowired
	private RobotService robotService;

	@BeforeEach
	public void configure() {
		robot = robotFactory.createRobot();
	}
	
	@Test
	public void robotStartPositionShouldBeInX2Y0South() {
		try {
			robotService.move(robot, "MMRMMRMM");
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(new Coordinate(2, 0).equals(robot.getCoordinate()));
		assertEquals(robot.getDirection(), Direction.SOUTH);
	}

	@Test
	public void robotStartPositionShouldBeInX0Y2West() {
		try {
			robotService.move(robot, "MML");
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(new Coordinate(0, 2).equals(robot.getCoordinate()));
		assertEquals(robot.getDirection(), Direction.WEST);
	}

	@Test
	public void robotShouldTurnToEastAfterFirstPosition() {
		robotService.turnRigth(robot);
		assertEquals(Direction.EAST, robot.getDirection());
	}

	@Test
	public void robotShouldTurnToWestAfterFirstPosition() {
		robotService.turnLeft(robot);
		assertEquals(Direction.WEST, robot.getDirection());
	}

	@Test
	public void robotShouldTurnToSouthWithTwoMoves() {
		robotService.turnLeft(robot);
		robotService.turnLeft(robot);
		assertEquals(Direction.SOUTH, robot.getDirection());
	}

	@Test
	public void robotShouldTurnToNorthWithTwoMoves() {
		robotService.turnLeft(robot);
		robotService.turnRigth(robot);
		assertEquals(Direction.NORTH, robot.getDirection());
	}

	@Test
	public void shoudlThrowMovementExceptionUsingAInvalidCommand() {
		assertThrows(MovementException.class, () -> {
			robotService.move(robot, "AAA");
		});
		
		assertThrows(MovementException.class, () -> {
			robotService.move(robot, "MMMMMMMMMMMMMMMMMMMMMMMM");
		});
		
		assertThrows(MovementException.class, () -> {
			robotService.move(robot, "");
		});
		
		assertThrows(MovementException.class, () -> {
			robotService.move(robot, null);
		});
	}

}
