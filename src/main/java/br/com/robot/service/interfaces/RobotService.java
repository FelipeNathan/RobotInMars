package br.com.robot.service.interfaces;

import br.com.robot.model.Robot;

public interface RobotService {

	void move(Robot robot, String route) throws Exception;
	
}
