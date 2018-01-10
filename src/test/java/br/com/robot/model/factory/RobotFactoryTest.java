package br.com.robot.model.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.robot.enums.Direction;
import br.com.robot.model.Coordinate;
import br.com.robot.model.Robot;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RobotFactoryTest {

	@Autowired
	private RobotFactory robotFactory;

	@Test
	public void robotStartPositionShouldBeInX0Y0North() {
		Robot robot = robotFactory.createRobot();
		assertTrue(new Coordinate(0, 0).equals(robot.getCoordinate()));
		assertEquals(robot.getDirection(), Direction.NORTH);
	}
}