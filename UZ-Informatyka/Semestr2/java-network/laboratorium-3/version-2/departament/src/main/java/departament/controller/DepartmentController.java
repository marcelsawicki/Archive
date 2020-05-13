package departament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	

}
