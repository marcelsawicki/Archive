package com.example.departament;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import departament.controller.HelloController;

@RunWith(SpringRunner.class)
@WebFluxTest(HelloController.class)
@ContextConfiguration(classes = {
   HelloController.class
 })
@AutoConfigureWebTestClient
class DepartamentApplicationTestA {
	
	@Autowired
	private WebTestClient webTestClient;
	
	@SuppressWarnings("deprecation")
	@Test
	public void testHelloController() {
		webTestClient.get()
						.uri("/api/hello")
						.accept(MediaType.APPLICATION_JSON)
						.exchange().expectStatus().isOk()
						.expectHeader()
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.expectBody()
						.jsonPath("$.content").isNotEmpty()
						.jsonPath("$.content").isEqualTo("Hello World!");
	}

}
