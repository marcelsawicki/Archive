package departament.controller;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import departament.model.Response;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestAttribute;

@SuppressWarnings("deprecation")
@Controller
public class HelloController {
	@GetMapping(value="/hello", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Response hello() {
		return new Response(1,
				"Hello World!");

	}
	
	@RequestMapping(value="/front")
	public String front(Model model) {
		model.addAttribute("title", "Hello World!");
		return "html/front";
	}

}