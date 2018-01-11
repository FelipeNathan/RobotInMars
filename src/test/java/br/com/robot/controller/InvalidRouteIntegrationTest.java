package br.com.robot.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class InvalidRouteIntegrationTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void shouldReturnBadRequestWithInvalidRoute() {
		ResponseEntity<String> response = this.testRestTemplate.getForEntity("/rest/", String.class);
		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
		
		response = this.testRestTemplate.getForEntity("/", String.class);
		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
		
		response = this.testRestTemplate.getForEntity("/rest/marte", String.class);
		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
	}

}
