package departament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import departament.model.Response;
import departament.repository.AppUserRepository;
import departament.repository.DepartmentRepository;
import departament.service.DepartmentService;
import departament.service.AppUserService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Autowired
    private DepartmentService departmentService;
    
    @Autowired
    private AppUserService appUserService;
    
	@GetMapping("/get")
	public String get() 
	{
		return departmentRepository.findAll().toString();
	}

	@GetMapping("/employes")
	public String employes() 
	{
		return departmentService.findDepartmentWithMaxNumberOfEmployes().toString();
	}
	
	@GetMapping("/salary")
	public String salary() 
	{
		return departmentService.findDepartmentWithMaxUsersSalary().toString();
	}
	
	/* Zadanie 3: a) zsumowanie rocznych wyplad dla dzialu (DEPARTAMENT_NAME) */
	@GetMapping(value="/sumyearsalary/{nazwa}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Response sumyearsalary(@PathVariable("nazwa") String nazwa) 
	{
		long result = departmentService.sumYearSalary(nazwa);
		String finalResult = Long.toString(result);
		return new Response(1,finalResult);
	}
	
	/* Zadanie 3: c) miesieczne podatko od wynagrodzen dla firmy, dla przekazanej jako parametr
	 * wysokosci (procentowej) podatku
	 */
	@GetMapping(value="/gettax/{nazwa}/{podatek}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Response sumyearsalary(@PathVariable("nazwa") String nazwa, @PathVariable("podatek") double podatek) 
	{
		double result = departmentService.getYearTax(nazwa,podatek);
		String finalResult = Double.toString(result);
		return new Response(1,finalResult);
	}

}
