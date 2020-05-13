package departament.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import departament.model.Response;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestAttribute;

@SuppressWarnings("deprecation")
@RestController
@RequestMapping(value="/api", method=RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
public class HelloController {
	@GetMapping(value="/hello", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Response hello() {
		return new Response(1,
				"Hello World!");

	}
	
	@GetMapping("/bla")
	public String bla() {
		return "Bla from Spring Boot!";
	}

}