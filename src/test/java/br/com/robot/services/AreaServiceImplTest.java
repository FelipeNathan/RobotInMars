package br.com.robot.services;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.robot.exception.MovementException;
import br.com.robot.model.Area;
import br.com.robot.model.factory.AreaFactory;
import br.com.robot.service.interfaces.AreaService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AreaServiceImplTest {

	@Autowired
	private AreaFactory areaFactory;
	
	@Autowired
	private AreaService areaService;
	
	@Test
	public void shouldThrowMovementExceptionExceedingLimitOfArea() {
		Area area = areaFactory.createArea(4, 4);
		assertThrows(MovementException.class, () -> { areaService.validateAreaLimit(area, 5); });
	}
	
	@Test
	public void shouldValidateNullAreaWithNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			areaService.validateAreaLimit(null, 0);
		});
	}
	

	@Test
	public void shouldNotThrowExceptionExceedingLimitOfArea() {
		Area area = areaFactory.createArea(4, 4);
		try {
			areaService.validateAreaLimit(area, 4); 
			areaService.validateAreaLimit(area, 0); 
		} catch (Exception e) {
			fail("Should not throw exception");
		}
	}
	
}
