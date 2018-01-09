package br.com.robot.service;

import org.springframework.stereotype.Service;

import br.com.robot.exception.MovementException;
import br.com.robot.model.Area;
import br.com.robot.service.interfaces.AreaService;

@Service
public class AreaServiceImpl implements AreaService {

	@Override
	public Area createArea(int x, int y) {
		return new Area(x, y);
	}

	@Override
	public void validateAreaLimit(Area area, int movementPosition) throws MovementException {
		
		if (area == null) {
			throw new NullPointerException("O robo não está em um planeta");
		}
		
		if (movementPosition > area.getMaxCoordinate().getY() || movementPosition > area.getMaxCoordinate().getX()
				|| movementPosition < area.getMinCoordinate().getY() || movementPosition < area.getMinCoordinate().getX()) {
			throw new MovementException("O movimento ultrapassou o limite do terreno");
		}
	}

}
