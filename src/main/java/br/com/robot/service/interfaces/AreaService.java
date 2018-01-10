package br.com.robot.service.interfaces;

import br.com.robot.exception.MovementException;
import br.com.robot.model.Area;

public interface AreaService {
	
	void validateAreaLimit(Area area, int movementPosition) throws MovementException;
}
