package br.com.robot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.robot.model.Robot;
import br.com.robot.model.factory.RobotFactory;
import br.com.robot.service.interfaces.RobotService;

@RestController
public class Home {

	@Autowired
	private RobotService robotService;
	
	@Autowired
	private RobotFactory robotFactory;

	@RequestMapping(value = "/rest/mars/{route}")
	public ResponseEntity<String> mars(@PathVariable(name = "route") String route) {

		try {
			Robot robot = robotFactory.createRobot();
			
			robotService.move(robot, route);
			String response = robot.getCoordinates();
			return ResponseEntity.ok(response);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST.name());
		}

	}
}
