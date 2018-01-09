package br.com.robot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.robot.exception.MovementException;

@RestController
public class InvalidRoute {
	
	@RequestMapping(value = "/**")
	public ResponseEntity<?> index() throws MovementException {
		return ResponseEntity.badRequest().body(new MovementException().getMessage());
	}
}
