package departament.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import departament.model.Department;
import departament.model.App_User;
import departament.model.Response;
import departament.repository.AppUserRepository;
import departament.service.AppUserService;
import departament.service.DepartmentService;

@Controller
public class App_UserController  {
	
    @Autowired
    private AppUserRepository appUserRepository;
    
    @Autowired
    private DepartmentService departmentService;
    
    @Autowired
    private AppUserService appUserService;
    
	@GetMapping("/")
	public String showMenu () {
		return "html/index";
	}
    
    @GetMapping("/usr")
	public String showPage (Model model, @RequestParam(defaultValue="0") int page) {
		model.addAttribute("data", appUserRepository.findAll(PageRequest.of(page, 4, Sort.unsorted())));
		model.addAttribute("currentPage", page);
		return "html/user";
    }
    
	@GetMapping("/usr/deleteusr")
	public String deleteCountry(Integer id)
	{
		appUserRepository.deleteById(id);
		return "redirect:/usr/";
	}
	
	@GetMapping("/usr/findOneusr")
	@ResponseBody
	public Optional<App_User> findOne(Integer id)
	{
		return appUserRepository.findById(id);
	}
	
	@PostMapping("/usr/saveusr")
	public String save(App_User app_user)
	{
		appUserRepository.save(app_user);
		return "redirect:/usr/";
	}
    
	@GetMapping("/getuser")
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
	
	/* Zadanie 3: b) zsumowanie rocznych wyplad dla osoby */
	@GetMapping(value="/sumyearsalary/{imie}/{nazwisko}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Response sumyearsalary(@PathVariable("imie") String imie, @PathVariable("nazwisko") String nazwisko) {
		long salary = appUserService.sumPayment(imie, nazwisko);
		String s2 = Long.toString(salary);
		return new Response(1,s2);
		
	}
	
    @GetMapping(value="/sumyearsalaryfront/{imie}/{nazwisko}")
	public String showPage (Model model, @PathVariable("imie") String imie, @PathVariable("nazwisko") String nazwisko) {
    	try 
    	{
    		long salary = appUserService.sumPayment(imie, nazwisko);
    		String s2 = Long.toString(salary);
    		model.addAttribute("data", s2);    		
    	}
    	catch(Exception e)
    	{
    		String s2 = "brak danych";
    		model.addAttribute("data", s2); 
    	}

		return "html/usersalary";
    }

}