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
public class HomeIntegrationTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void shouldMoveToX2Y0South() {
		String response = testRestTemplate.getForObject("/rest/mars/MMRMMRMM", String.class);
		assertEquals("(2,0,S)", response);
	}

	@Test
	public void shouldMoveToX0Y2West() {
		String response = testRestTemplate.getForObject("/rest/mars/MML", String.class);
		assertEquals("(0,2,W)", response);
	}

	@Test
	public void shouldMoveToX0Y2WestExecutingTwice() {
		String response = testRestTemplate.getForObject("/rest/mars/MML", String.class);
		assertEquals("(0,2,W)", response);

		response = testRestTemplate.getForObject("/rest/mars/MML", String.class);
		assertEquals("(0,2,W)", response);
	}

	@Test
	public void shouldReturnBadRequestWithInvalidCommand() {
		ResponseEntity<String> response = this.testRestTemplate.getForEntity("/rest/mars/AAA", String.class);
		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
	}

	@Test
	public void shouldReturnBadRequestMovingBeyongTheLimit() {
		ResponseEntity<String> response = this.testRestTemplate.getForEntity("/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM",
				String.class);
		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
	}
}
