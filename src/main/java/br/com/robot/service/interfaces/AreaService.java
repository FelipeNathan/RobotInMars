package br.com.robot.service.interfaces;

import br.com.robot.exception.MovementException;
import br.com.robot.model.Area;

public interface AreaService {

	Area createArea(int x, int y);
	
	void validateAreaLimit(Area area, int movementPosition) throws MovementException;
}
