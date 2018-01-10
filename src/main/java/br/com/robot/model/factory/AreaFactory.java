package br.com.robot.model.factory;

import org.springframework.stereotype.Component;

import br.com.robot.model.Area;

@Component
public class AreaFactory {
	
	public Area createArea(int x, int y) {
		return new Area(x, y);
	}
	
}
