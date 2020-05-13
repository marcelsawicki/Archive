package departament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import departament.model.Greeting;
import departament.repository.AppUserRepository;
import departament.service.AppUserService;
import departament.service.DepartmentService;

@RestController
@RequestMapping(value="/app-user", method=RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
public class App_UserController  {
	
    @Autowired
    private AppUserRepository appUserRepository;
    
    @Autowired
    private DepartmentService departmentService;
    
    @Autowired
    private AppUserService appUserService;
    
    
	@GetMapping("/get")
	public String get() {
		return appUserRepository.findAll().toString();
	}
	
	@GetMapping("/findUser/{imie}/{nazwisko}")
	public String findUser(@PathVariable("imie") String imie, @PathVariable("nazwisko") String nazwisko) {
		return appUserService.findUser(imie,nazwisko).toString();
	}
	
	@GetMapping("/findUserFromDepartment/{nazwa}")
	public String findUserFromDepartment(@PathVariable("nazwa") String nazwa) {
		return appUserService.findUsersFromDepartment(nazwa).toString();
	}
	
	@GetMapping("/payment")
	public String payent() {
		return appUserService.findUsersWithPaymentIsHigher(5L).toString();
	}
	
	@GetMapping(value="/sumyearsalary", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Greeting sumyearsalary() {
		long salary = appUserService.sumPayment("Zygmunt", "Kowalski");
		String s2 = Long.toString(salary);
		return new Greeting(1,s2);
		
	}

}