package com.example.departament;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
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
class DepartmentControllerTest {
	
	@Autowired
	private WebTestClient webTestClient;
	
	/* Zadanie 3: a) zsumowanie rocznych wyplad dla dzialu (DEPARTAMENT_NAME) */
	@SuppressWarnings("deprecation")
	@Test
	public void testFunctionA1sell() {
		webTestClient.get()
						.uri("/department/sumyearsalary/sprzedaz")
						.accept(MediaType.APPLICATION_JSON)
						.exchange().expectStatus().isOk()
						.expectHeader()
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.expectBody()
						.jsonPath("$.content").isNotEmpty()
						.jsonPath("$.content").isEqualTo("40000");
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testFunctionA2deploy() {
		webTestClient.get()
						.uri("/department/sumyearsalary/wdrozenia")
						.accept(MediaType.APPLICATION_JSON)
						.exchange().expectStatus().isOk()
						.expectHeader()
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.expectBody()
						.jsonPath("$.content").isNotEmpty()
						.jsonPath("$.content").isEqualTo("25000");
	}

	/* Zadanie 3: c) miesieczne podatko od wynagrodzen dla firmy, dla przekazanej jako parametr
	 * wysokosci (procentowej) podatku
	 */
	@Test
	public void testFunctionC1sell23() {
		webTestClient.get()
						.uri("/department/gettax/sprzedaz/23")
						.accept(MediaType.APPLICATION_JSON)
						.exchange().expectStatus().isOk()
						.expectHeader()
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.expectBody()
						.jsonPath("$.content").isNotEmpty()
						.jsonPath("$.content").isEqualTo("9200.0");
	}
	
	@Test
	public void testFunctionC2sell5() {
		webTestClient.get()
						.uri("/department/gettax/sprzedaz/5")
						.accept(MediaType.APPLICATION_JSON)
						.exchange().expectStatus().isOk()
						.expectHeader()
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.expectBody()
						.jsonPath("$.content").isNotEmpty()
						.jsonPath("$.content").isEqualTo("2000.0");
	}
	
	@Test
	public void testFunctionC3sell8() {
		webTestClient.get()
						.uri("/department/gettax/sprzedaz/8")
						.accept(MediaType.APPLICATION_JSON)
						.exchange().expectStatus().isOk()
						.expectHeader()
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.expectBody()
						.jsonPath("$.content").isNotEmpty()
						.jsonPath("$.content").isEqualTo("3200.0");
	}
	
	@Test
	public void testFunctionC4deploy8() {
		webTestClient.get()
						.uri("/department/gettax/wdrozenia/8")
						.accept(MediaType.APPLICATION_JSON)
						.exchange().expectStatus().isOk()
						.expectHeader()
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.expectBody()
						.jsonPath("$.content").isNotEmpty()
						.jsonPath("$.content").isEqualTo("2000.0");
	}

}
