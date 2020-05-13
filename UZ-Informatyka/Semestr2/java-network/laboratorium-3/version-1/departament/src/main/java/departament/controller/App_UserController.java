package departament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import departament.repository.AppUserRepository;
import departament.service.AppUserService;
import departament.service.DepartmentService;

@RestController
@RequestMapping("/app-user")
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

}