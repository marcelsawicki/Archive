package com.example.departament;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import departament.DepartamentApplication;
import departament.controller.App_UserController;

@RunWith(SpringRunner.class)
//@WebFluxTest(App_UserController.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {
		App_UserController.class,
		DepartamentApplication.class
 })
@AutoConfigureWebTestClient
class App_UserControllerTest {
	
	@Autowired
	private WebTestClient webTestClient;
	
	@Test
	public void test1() {
		
		//Mockito.when(appUserService.sumPayment("Zygmunt", "Kowalski"));
		webTestClient.get()
						.uri("/app-user/sumyearsalary")
						.accept(MediaType.APPLICATION_JSON)
						.exchange().expectStatus().isOk()
						.expectHeader()
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.expectBody()
						.jsonPath("$.content").isNotEmpty()
						.jsonPath("$.content").isEqualTo("240000");
	}

}
