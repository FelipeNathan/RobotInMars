package br.com.robot.service.interfaces;

import br.com.robot.exception.MovementException;
import br.com.robot.model.Robot;

public interface RobotService {

	void move(Robot robot, String route) throws Exception;
	
	void doStep(Robot robot) throws MovementException;
	
	void turnRigth(Robot robot);
	
	void turnLeft(Robot robot);
}
